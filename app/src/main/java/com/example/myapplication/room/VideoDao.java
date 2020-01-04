package com.example.myapplication.room;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * author: hedianbo.
 * date: 2019-12-27
 * desc:
 */
@Dao
public interface VideoDao {

    // OnConflictStrategy.REPLACE表示如果已经有数据，那么就覆盖掉
   //返回Long数据表示，插入条目的主键值（uid）
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insterVideo(VideoBean videoBean);

    //根据条件查询，方法参数和注解的sql语句参数一一对应
    @Query("SELECT * FROM video WHERE material_url IN (:material_url)")
    VideoBean queryVideo(String material_url);

}
