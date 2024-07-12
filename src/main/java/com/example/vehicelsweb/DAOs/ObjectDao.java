package com.example.vehicelsweb.DAOs;

import java.util.List;

public interface ObjectDao<DbPojo> {
    List<DbPojo> getAllObjects();
    void save(DbPojo object);
}
