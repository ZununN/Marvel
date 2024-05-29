package kz.zunun.data.core.dataBase

import androidx.room.*


@Dao
interface CharactersDao {

    @Query("SELECT * FROM ${Character.TABLE_NAME} WHERE id = :id ")
    suspend fun getCharacterById(id: Int): Character?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diaryUnit: Character)

}

@Entity(tableName = Character.TABLE_NAME)
data class Character(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val imageUrl: String,
){
    companion object{
        const val TABLE_NAME = "characters"
    }
}

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class CharactersDatabase : RoomDatabase() {

    companion object {
        const val NAME = "app_database"
    }

    abstract fun dao(): CharactersDao
}