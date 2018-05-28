package models.account;

import de.themonstrouscavalca.dbaser.models.impl.BasicIdentifiedModel;
import de.themonstrouscavalca.dbaser.utils.ResultSetTableAware;

import java.sql.SQLException;
import java.util.Map;

public class User extends BasicIdentifiedModel{
    private final String TABLE_PREFIX = "users";

    @Override
    public String getTablePrefix(){
        return TABLE_PREFIX;
    }

    private String name;
    private String email;
    private String passwordHash;
    private String passwordSalt;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPasswordHash(){
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt(){
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt){
        this.passwordSalt = passwordSalt;
    }

    public Map<String, Object> exportToMap(){
        Map<String, Object> exportMap = this.baseExportToMap();
        exportMap.put("name", this.getName());
        exportMap.put("email", this.getEmail());
        exportMap.put("password_hash", this.getPasswordHash());
        exportMap.put("password_salt", this.getPasswordSalt());
        return exportMap;
    }

    @Override
    protected void setRemainderFromResultSet(ResultSetTableAware rs) throws SQLException{
        if(rs.has(this.getTablePrefixedFieldName("name"))){
            this.setName(rs.getString(this.getTablePrefixedFieldName("name")));
        }

        if(rs.has(this.getTablePrefixedFieldName("email"))){
            this.setEmail(rs.getString(this.getTablePrefixedFieldName("email")));
        }

        if(rs.has(this.getTablePrefixedFieldName("password_hash"))){
            this.setPasswordHash(rs.getString(this.getTablePrefixedFieldName("password_hash")));
        }

        if(rs.has(this.getTablePrefixedFieldName("password_salt"))){
            this.setPasswordSalt(rs.getString(this.getTablePrefixedFieldName("password_salt")));
        }
    }
}
