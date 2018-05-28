package models.tea;

import de.themonstrouscavalca.dbaser.models.impl.BasicIdentifiedModel;
import de.themonstrouscavalca.dbaser.utils.ResultSetTableAware;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TeaGroup extends BasicIdentifiedModel{
    private final String TABLE_PREFIX = "tea_groups";

    @Override
    public String getTablePrefix(){
        return TABLE_PREFIX;
    }

    private Collection<Long> userIds = new ArrayList<>();

    public Collection<Long> getUserIds(){
        return userIds;
    }

    public void setUserIds(Collection<Long> userIds){
        this.userIds = userIds;
    }

    public void addUserId(Long userId){
        this.userIds.add(userId);
    }

    @Override
    protected void setRemainderFromResultSet(ResultSetTableAware rs) throws SQLException{
        if(rs.has(this.getTablePrefixedFieldName("user_id"))){
            this.addUserId(rs.getLong(this.getTablePrefixedFieldName("user_id")));
        }
    }

    @Override
    public Map<String, Object> exportToMap(){
        Map<String, Object> params = new HashMap<>();
        params.put("id", this.getId());
        params.put("userIds", this.getUserIds());
        return params;
    }
}
