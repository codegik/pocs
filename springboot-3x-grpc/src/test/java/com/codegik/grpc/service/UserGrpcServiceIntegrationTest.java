package com.codegik.grpc.service;

import com.codegik.grpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for UserService gRPC API
 * Tests all CRUD operations using Spring Boot Test context with in-process gRPC server
 * The gRPC server auto-configuration is excluded to avoid version compatibility issues
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
        GrpcServerAutoConfiguration.class,
        GrpcServerFactoryAutoConfiguration.class
})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext
class UserGrpcServiceIntegrationTest {

    @Autowired
    private UserGrpcService userGrpcService;

    private UserServiceGrpc.UserServiceBlockingStub userServiceStub;
    private ManagedChannel channel;
    private Server inProcessServer;

    private static Long createdUserId;

    @BeforeEach
    void setUp() throws Exception {
        String serverName = InProcessServerBuilder.generateName();

        // Create in-process server with the actual service
        inProcessServer = InProcessServerBuilder.forName(serverName)
                .directExecutor()
                .addService(userGrpcService)
                .build()
                .start();

        // Create in-process channel
        channel = InProcessChannelBuilder.forName(serverName)
                .directExecutor()
                .build();

        userServiceStub = UserServiceGrpc.newBlockingStub(channel);
    }

    @AfterEach
    void tearDown() {
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
        }
        if (inProcessServer != null && !inProcessServer.isShutdown()) {
            inProcessServer.shutdown();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Should create a new user successfully")
    void testCreateUser() {
        // Given
        CreateUserRequest request = CreateUserRequest.newBuilder()
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .build();

        // When
        UserResponse response = userServiceStub.createUser(request);

        // Then
        assertNotNull(response);
        assertNotNull(response.getUser());
        assertTrue(response.getUser().getId() > 0);
        assertEquals("John Doe", response.getUser().getName());
        assertEquals("john.doe@example.com", response.getUser().getEmail());
        assertEquals("User created successfully", response.getMessage());

        // Save the ID for subsequent tests
        createdUserId = response.getUser().getId();
    }

    @Test
    @Order(2)
    @DisplayName("Should retrieve an existing user by ID")
    void testGetUser() {
        // Given
        assertNotNull(createdUserId, "User should be created first");
        GetUserRequest request = GetUserRequest.newBuilder()
                .setId(createdUserId)
                .build();

        // When
        UserResponse response = userServiceStub.getUser(request);

        // Then
        assertNotNull(response);
        assertNotNull(response.getUser());
        assertEquals(createdUserId, response.getUser().getId());
        assertEquals("John Doe", response.getUser().getName());
        assertEquals("john.doe@example.com", response.getUser().getEmail());
        assertEquals("User found", response.getMessage());
    }

    @Test
    @Order(3)
    @DisplayName("Should return message when getting non-existent user")
    void testGetNonExistentUser() {
        // Given
        GetUserRequest request = GetUserRequest.newBuilder()
                .setId(99999L)
                .build();

        // When
        UserResponse response = userServiceStub.getUser(request);

        // Then
        assertNotNull(response);
        assertEquals("User not found", response.getMessage());
    }

    @Test
    @Order(4)
    @DisplayName("Should update an existing user successfully")
    void testUpdateUser() {
        // Given
        assertNotNull(createdUserId, "User should be created first");
        UpdateUserRequest request = UpdateUserRequest.newBuilder()
                .setId(createdUserId)
                .setName("John Updated")
                .setEmail("john.updated@example.com")
                .build();

        // When
        UserResponse response = userServiceStub.updateUser(request);

        // Then
        assertNotNull(response);
        assertNotNull(response.getUser());
        assertEquals(createdUserId, response.getUser().getId());
        assertEquals("John Updated", response.getUser().getName());
        assertEquals("john.updated@example.com", response.getUser().getEmail());
        assertEquals("User updated successfully", response.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("Should return message when updating non-existent user")
    void testUpdateNonExistentUser() {
        // Given
        UpdateUserRequest request = UpdateUserRequest.newBuilder()
                .setId(99999L)
                .setName("Non Existent")
                .setEmail("nonexistent@example.com")
                .build();

        // When
        UserResponse response = userServiceStub.updateUser(request);

        // Then
        assertNotNull(response);
        assertEquals("User not found", response.getMessage());
    }

    @Test
    @Order(6)
    @DisplayName("Should list all users")
    void testListUsers() {
        // Given
        ListUsersRequest request = ListUsersRequest.newBuilder().build();

        // When
        ListUsersResponse response = userServiceStub.listUsers(request);

        // Then
        assertNotNull(response);
        assertNotNull(response.getUsersList());
        assertFalse(response.getUsersList().isEmpty());

        // Verify our created user is in the list
        boolean userFound = response.getUsersList().stream()
                .anyMatch(user -> user.getId() == createdUserId);
        assertTrue(userFound, "Created user should be in the list");
    }

    @Test
    @Order(7)
    @DisplayName("Should create multiple users and list them")
    void testCreateMultipleUsersAndList() {
        // Given - Create additional users
        CreateUserRequest request1 = CreateUserRequest.newBuilder()
                .setName("Alice Smith")
                .setEmail("alice.smith@example.com")
                .build();

        CreateUserRequest request2 = CreateUserRequest.newBuilder()
                .setName("Bob Johnson")
                .setEmail("bob.johnson@example.com")
                .build();

        // When
        UserResponse response1 = userServiceStub.createUser(request1);
        UserResponse response2 = userServiceStub.createUser(request2);
        ListUsersResponse listResponse = userServiceStub.listUsers(
                ListUsersRequest.newBuilder().build()
        );

        // Then
        assertNotNull(response1.getUser());
        assertNotNull(response2.getUser());
        assertTrue(listResponse.getUsersList().size() >= 3);

        // Verify all users are present
        assertEquals(3, listResponse.getUsersList().stream()
                .filter(user ->
                    user.getName().equals("John Updated") ||
                    user.getName().equals("Alice Smith") ||
                    user.getName().equals("Bob Johnson"))
                .count());
    }

    @Test
    @Order(8)
    @DisplayName("Should delete an existing user successfully")
    void testDeleteUser() {
        // Given
        assertNotNull(createdUserId, "User should be created first");
        DeleteUserRequest request = DeleteUserRequest.newBuilder()
                .setId(createdUserId)
                .build();

        // When
        DeleteUserResponse response = userServiceStub.deleteUser(request);

        // Then
        assertNotNull(response);
        assertTrue(response.getSuccess());
        assertEquals("User deleted successfully", response.getMessage());

        // Verify user is actually deleted
        GetUserRequest getRequest = GetUserRequest.newBuilder()
                .setId(createdUserId)
                .build();
        UserResponse getResponse = userServiceStub.getUser(getRequest);
        assertEquals("User not found", getResponse.getMessage());
    }

    @Test
    @Order(9)
    @DisplayName("Should return failure when deleting non-existent user")
    void testDeleteNonExistentUser() {
        // Given
        DeleteUserRequest request = DeleteUserRequest.newBuilder()
                .setId(99999L)
                .build();

        // When
        DeleteUserResponse response = userServiceStub.deleteUser(request);

        // Then
        assertNotNull(response);
        assertFalse(response.getSuccess());
        assertEquals("User not found", response.getMessage());
    }

    @Test
    @Order(10)
    @DisplayName("Should handle empty email field")
    void testCreateUserWithEmptyEmail() {
        // Given
        CreateUserRequest request = CreateUserRequest.newBuilder()
                .setName("Test User")
                .setEmail("")
                .build();

        // When
        UserResponse response = userServiceStub.createUser(request);

        // Then
        assertNotNull(response);
        assertNotNull(response.getUser());
        assertEquals("", response.getUser().getEmail());
    }

    @Test
    @Order(11)
    @DisplayName("Should handle full CRUD lifecycle")
    void testFullCrudLifecycle() {
        // Create
        CreateUserRequest createRequest = CreateUserRequest.newBuilder()
                .setName("Lifecycle Test User")
                .setEmail("lifecycle@example.com")
                .build();
        UserResponse createResponse = userServiceStub.createUser(createRequest);
        long userId = createResponse.getUser().getId();

        assertEquals("User created successfully", createResponse.getMessage());
        assertEquals("Lifecycle Test User", createResponse.getUser().getName());

        // Read
        GetUserRequest getRequest = GetUserRequest.newBuilder()
                .setId(userId)
                .build();
        UserResponse getResponse = userServiceStub.getUser(getRequest);

        assertEquals("User found", getResponse.getMessage());
        assertEquals("lifecycle@example.com", getResponse.getUser().getEmail());

        // Update
        UpdateUserRequest updateRequest = UpdateUserRequest.newBuilder()
                .setId(userId)
                .setName("Updated Lifecycle User")
                .setEmail("updated.lifecycle@example.com")
                .build();
        UserResponse updateResponse = userServiceStub.updateUser(updateRequest);

        assertEquals("User updated successfully", updateResponse.getMessage());
        assertEquals("Updated Lifecycle User", updateResponse.getUser().getName());

        // Delete
        DeleteUserRequest deleteRequest = DeleteUserRequest.newBuilder()
                .setId(userId)
                .build();
        DeleteUserResponse deleteResponse = userServiceStub.deleteUser(deleteRequest);

        assertTrue(deleteResponse.getSuccess());
        assertEquals("User deleted successfully", deleteResponse.getMessage());

        // Verify deletion
        UserResponse getAfterDeleteResponse = userServiceStub.getUser(getRequest);
        assertEquals("User not found", getAfterDeleteResponse.getMessage());
    }
}
