import pygame
import random
import sys
import os

pygame.init()

WIDTH, HEIGHT = 1280, 800
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Space Invaders")

BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)
RED = (255, 0, 0)

SPACESHIP_IMG = pygame.transform.scale(pygame.image.load(os.path.join('spaceship.png')), (50, 50))

ALIEN_IMGS = [pygame.transform.scale(img, (60, 60)) for img in [
    pygame.image.load(os.path.join('alien_1.png')),
    pygame.image.load(os.path.join('alien_2.png')),
    pygame.image.load(os.path.join('alien_3.png'))
]]

PLAYER_BULLET_IMG = pygame.transform.scale(pygame.image.load(os.path.join('spaceship_bullet.png')), (14, 20))

ALIEN_BULLET_IMG = pygame.transform.scale(pygame.image.load(os.path.join('aliens_bullet.png')), (14, 20))

PLAYER_SIZE = (50, 50)
PLAYER_SPEED = 5
BULLET_SIZE = (14, 20)
BULLET_SPEED = 7
ALIEN_SIZE = (60, 60)
ALIEN_ROWS = 5
ALIEN_COLS = 10
ALIEN_PADDING = 15
ALIEN_SPEED = 1
ALIEN_DROP_DISTANCE = 20
ALIEN_BULLET_SPEED = 3
ALIEN_FIRE_RATE = 0.005
ALIEN_POINTS = 10

font = pygame.font.Font(None, 36)
large_font = pygame.font.Font(None, 64)


class Game:
    def __init__(self):
        self.running = True
        self.game_over = False
        self.clock = pygame.time.Clock()
        self.player = Player(WIDTH // 2 - PLAYER_SIZE[0] // 2, HEIGHT - PLAYER_SIZE[1] - 20)
        self.bullets = []
        self.aliens = []
        self.alien_bullets = []
        self.score = 0
        self.lives = 3
        self.alien_direction = 1
        self.alien_speed = ALIEN_SPEED
        self.show_start_screen = True

    def reset_game(self):
        self.score = 0
        self.lives = 3
        self.game_over = False
        self.alien_speed = ALIEN_SPEED
        self.player = Player(WIDTH // 2 - PLAYER_SIZE[0] // 2, HEIGHT - PLAYER_SIZE[1] - 20)
        self.bullets = []
        self.alien_bullets = []
        self.create_aliens()

    def create_aliens(self):
        self.aliens = []
        start_x = (WIDTH - (ALIEN_COLS * (ALIEN_SIZE[0] + ALIEN_PADDING))) // 2
        start_y = 50

        for row in range(ALIEN_ROWS):
            for col in range(ALIEN_COLS):
                x = start_x + col * (ALIEN_SIZE[0] + ALIEN_PADDING)
                y = start_y + row * (ALIEN_SIZE[1] + ALIEN_PADDING)
                self.aliens.append(Alien(x, y))

        self.alien_direction = 1

    def handle_events(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.running = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    self.running = False
                if self.show_start_screen:
                    self.show_start_screen = False
                    self.reset_game()
                if self.game_over and event.key == pygame.K_r:
                    self.reset_game()
                if not self.game_over and event.key == pygame.K_SPACE:
                    self.player.shoot(self.bullets)

    def update(self):
        if self.game_over:
            return

        self.player.update()

        for bullet in self.bullets[:]:
            y = bullet.move()
            if y < 0:
                self.bullets.remove(bullet)

        for bullet in self.alien_bullets[:]:
            y = bullet.move()
            if y > HEIGHT:
                self.alien_bullets.remove(bullet)

        self.update_aliens()
        self.check_collisions()

    def update_aliens(self):
        if not self.aliens:
            return

        move_down = False

        for alien in self.aliens:
            if (self.alien_direction > 0 and alien.x + alien.width >= WIDTH) or \
               (self.alien_direction < 0 and alien.x <= 0):
                self.alien_direction *= -1
                move_down = True
                break

        for alien in self.aliens:
            alien.x += self.alien_direction * self.alien_speed
            if move_down:
                alien.y += ALIEN_DROP_DISTANCE

            if alien.y + alien.height >= self.player.y:
                self.game_over = True
                return

            if random.random() < ALIEN_FIRE_RATE:
                bullet = AlienBullet(alien.x + alien.width // 2, alien.y + alien.height)
                self.alien_bullets.append(bullet)

    def check_collisions(self):
        for bullet in self.bullets[:]:
            for alien in self.aliens[:]:
                if self.check_collision(bullet, alien):
                    if bullet in self.bullets:
                        self.bullets.remove(bullet)
                    self.aliens.remove(alien)
                    self.score += ALIEN_POINTS
                    break

        if not self.aliens:
            self.create_aliens()

        for bullet in self.alien_bullets[:]:
            if self.check_collision(bullet, self.player):
                self.alien_bullets.remove(bullet)
                self.lives -= 1
                if self.lives <= 0:
                    self.game_over = True

    def check_collision(self, bullet, player):
        return (bullet.x < player.x + player.width and
                bullet.x + bullet.width > player.x and
                bullet.y < player.y + player.height and
                bullet.y + bullet.height > player.y)

    def draw(self):
        screen.fill(BLACK)
        if self.show_start_screen:
            self.draw_start_screen()
        elif not self.game_over:
            self.player.draw()
            for bullet in self.bullets:
                bullet.draw()
            for alien in self.aliens:
                alien.draw()
            for bullet in self.alien_bullets:
                bullet.draw()
            self.draw_ui()
        elif self.game_over:
            self.draw_game_over()

        pygame.display.flip()

    def draw_start_screen(self):
        title = large_font.render("SPACE INVADERS", True, GREEN)
        instruction = font.render("Press any key to start", True, WHITE)
        controls = font.render("Arrow keys to move, Space to shoot", True, WHITE)
        screen.blit(title, (WIDTH // 2 - title.get_width() // 2, HEIGHT // 3))
        screen.blit(instruction, (WIDTH // 2 - instruction.get_width() // 2, HEIGHT // 2))
        screen.blit(controls, (WIDTH // 2 - controls.get_width() // 2, HEIGHT // 2 + 50))

    def draw_game_over(self):
        game_over_text = large_font.render("GAME OVER", True, RED)
        score_text = font.render(f"Final Score: {self.score}", True, WHITE)
        restart_text = font.render("Press R to restart", True, WHITE)
        screen.blit(game_over_text, (WIDTH // 2 - game_over_text.get_width() // 2, HEIGHT // 3))
        screen.blit(score_text, (WIDTH // 2 - score_text.get_width() // 2, HEIGHT // 2))
        screen.blit(restart_text, (WIDTH // 2 - restart_text.get_width() // 2, HEIGHT // 2 + 50))

    def draw_ui(self):
        score_text = font.render(f"Score: {self.score}", True, WHITE)
        lives_text = font.render(f"Lives: {self.lives}", True, WHITE)
        screen.blit(score_text, (10, 10))
        screen.blit(lives_text, (WIDTH - lives_text.get_width() - 10, 10))

    def run(self):
        while self.running:
            self.handle_events()
            self.update()
            self.draw()
            self.clock.tick(60)  # 60 FPS


class Player:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.width = PLAYER_SIZE[0]
        self.height = PLAYER_SIZE[1]
        self.image = SPACESHIP_IMG
        self.shoot_cooldown = 0

    def update(self):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT] and self.x > 0:
            self.x -= PLAYER_SPEED
        if keys[pygame.K_RIGHT] and self.x < WIDTH - self.width:
            self.x += PLAYER_SPEED
        if self.shoot_cooldown > 0:
            self.shoot_cooldown -= 1

    def shoot(self, bullets_list):
        if self.shoot_cooldown == 0:
            bullet_x = self.x + self.width // 2 - BULLET_SIZE[0] // 2
            bullets_list.append(PlayerBullet(bullet_x, self.y))
            self.shoot_cooldown = 12

    def draw(self):
        screen.blit(self.image, (self.x, self.y))


class PlayerBullet:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.width = BULLET_SIZE[0]
        self.height = BULLET_SIZE[1]
        self.image = PLAYER_BULLET_IMG

    def move(self):
        self.y -= BULLET_SPEED
        return self.y

    def draw(self):
        screen.blit(self.image, (self.x, self.y))


class AlienBullet:
    def __init__(self, x, y):
        self.x = x - BULLET_SIZE[0] // 2
        self.y = y
        self.width = BULLET_SIZE[0]
        self.height = BULLET_SIZE[1]
        self.image = ALIEN_BULLET_IMG

    def move(self):
        self.y += ALIEN_BULLET_SPEED
        return self.y

    def draw(self):
        screen.blit(self.image, (self.x, self.y))


class Alien:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.width = ALIEN_SIZE[0]
        self.height = ALIEN_SIZE[1]
        self.image = ALIEN_IMGS[random.randint(0, 2)]

    def draw(self):
        screen.blit(self.image, (self.x, self.y))


if __name__ == "__main__":
    game = Game()
    game.run()
    pygame.quit()
    sys.exit()
