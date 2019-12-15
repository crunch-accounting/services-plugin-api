package uk.co.crunch.platform.api.database;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MySqlDataSourceTest {

    @Test
    @MySqlDataSource(schema = "insurancedb")
    public void testLongForm() throws NoSuchMethodException {
        final MySqlDataSource ann = this.getClass().getMethod("testLongForm").getAnnotation(MySqlDataSource.class);
        assertThat(ann.schema()).isEqualTo("insurancedb");
        assertThat(ann.grants()).isEqualTo("SELECT,INSERT,UPDATE,DELETE");
    }

    @Test
    @MySqlDataSource(schema = "insurancedb", customConfigName = "readonly", grants = "SELECT")
    public void testLongFormReadOnly() throws NoSuchMethodException {
        final MySqlDataSource ann = this.getClass().getMethod("testLongFormReadOnly").getAnnotation(MySqlDataSource.class);
        assertThat(ann.schema()).isEqualTo("insurancedb");
        assertThat(ann.grants()).isEqualTo("SELECT");
    }

    @Test
    @MySqlDataSource(schema = "blahDb")
    public void testShortForm() throws NoSuchMethodException {
        final MySqlDataSource ann = this.getClass().getMethod("testShortForm").getAnnotation(MySqlDataSource.class);
        assertThat(ann.schema()).isEqualTo("blahDb");
        assertThat(ann.grants()).isEqualTo("SELECT,INSERT,UPDATE,DELETE");
    }
}
