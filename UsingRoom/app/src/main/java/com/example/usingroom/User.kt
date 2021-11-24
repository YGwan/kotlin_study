package com.example.room

import androidx.room.*

//Entity = 데이터 구조 정의
@Entity(tableName="users")
data class User( //기본적으로 Room은 클래스 이름을 데이터베이스 테이블 이름으로 사용합니다.

    //Each entity must define at least 1 field as a primary key.
    @PrimaryKey val uid: Int,
    //Define fields. Room uses the field names as the column names in the database
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)

//Dao = database에 접근하기 위해 여러가지 API를 정의
@Dao//Dao는 데이터베이스에 접근할 수 있는 편의 방법을 정의합니다.
interface UserDao {

    @Query("SELECT * FROM users")
    //사용자 테이블의 모든 데이터 쿼리 및 반환
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    //테이블의 uid 필드가 usersIds 매개 변수에 있는 사용자 테이블의 모든 데이터를 쿼리하고 반환합니다.
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    //테이블의 first_name 필드가 first 매개 변수이고 테이블의 last_name 필드가 last 매개 변수와 같은
    // 사용자 테이블의 데이터를 쿼리합니다. 쿼리 결과의 첫 번째 데이터를 반환합니다.
    fun findByName(first: String, last: String): User

    @Insert
    //테이블에 사용자 삽입
    fun insertAll(vararg users: User)

    @Delete
    //테이블에 사용자 제거
    fun delete(users: User)
}

//실제 database구조 정의
@Database(entities = arrayOf(User::class), version=1)
abstract class UserDB : RoomDatabase() {//UserDB는 RoomDatabase 클래스를 상속하는 추상 클래스입니다.
    abstract fun userDao(): UserDao //Dao는 UserDB의 데이터에 액세스합니다.
}
