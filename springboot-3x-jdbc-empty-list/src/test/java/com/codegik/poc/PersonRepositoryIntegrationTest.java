package com.codegik.poc;

import com.codegik.poc.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.BadSqlGrammarException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PersonRepositoryIntegrationTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void option1ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption1(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE id IN ()]");
    }

    @Test
    void option2ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption2(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE ()::bigint[] IS NULL OR id = ANY(()::bigint[])]");
    }

    @Test
    void option3ShouldSucceed() {
        assertThat(repository.findByIdInOption3(List.of())).isEmpty();
    }

    @Test
    void option4ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption4(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE (? = false AND id IN ())]");
    }

    @Test
    void option5ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption5(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE (1=0 OR id IN ())]");
    }

    @Test
    void option6ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption6(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person p WHERE EXISTS (SELECT 1 FROM unnest(CAST( AS bigint[])) AS i(id) WHERE p.id = i.id) OR cardinality() = 0]");
    }

    @Test
    void option7ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption7(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE (? = true) OR (? = true) OR id IN ()]");
    }

    @Test
    void option8ShouldSucceed() {
        assertThat(repository.findByIdInOption8(null)).isNotEmpty();
    }

    @Test
    void option9ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption9(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE id IN ()]");
    }

    @Test
    void option10ShouldFail() {
        Exception exception = assertThrows(BadSqlGrammarException.class, () -> {
            repository.findByIdInOption10(List.of());
        });
        assertThat(exception).hasMessageContaining("[SELECT * FROM person WHERE array_length(::bigint[], 1) IS NULL OR id IN ()]");
    }


}
