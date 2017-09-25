package uk.co.crunch.platform.api.database;

public class VaultDatabaseCommands {

    // Config is now purely a factor of host (well, and port...) since a config permits *all* roles
    public static String getConfigName(final MySqlDataSource ds) {
        // return "rds_" + ds.configName();
        return ds.instance().customConfigName().isEmpty() ? ds.instance().host().replace('.','_').replace('-','_') : ds.instance().customConfigName();
    }

    public static String getRoleName(final MySqlDataSource ds) {
        return ds.schema() + "_" + ( ds.customConfigName().isEmpty() ? "default" : ds.customConfigName());
    }

    public static String getDbConnectionUrl(final MySqlDataSource ds) {
        return "root:mysql@tcp(" + ds.instance().host() + ":" + ds.instance().port() + ")/";
    }

    public static String getUserCreationStatement(final MySqlDataSource ds) {
        return "CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT " + ds.grants() + " ON " + ds.schema() + ".* TO '{{name}}'@'%';";
    }
}
