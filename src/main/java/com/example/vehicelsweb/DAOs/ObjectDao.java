package com.example.vehicelsweb.DAOs;

import java.util.List;

public interface ObjectDao<DbPojo> {
    public List<DbPojo> getAllObjects();
    public void save(DbPojo object);
}
