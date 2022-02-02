package by.overone.it.repository;

import by.overone.it.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("from User where nickname =:nickname")
    User findByNickname(@Param("nickname") String nickname);

    @Query("from User where id =:id")
    User getById(@Param("id") String id);

    @Query("update User set price =:price where id =:id")
    @Modifying
    void updateCryptoPrice(@Param("price") String price, @Param("id") String id);

    @Query("update User set cryptoSymbol =:symbol where id =:id")
    @Modifying
    void updateCryptoSymbol(@Param("symbol") String symbol, @Param("id") String id);

    @Query("from User where cryptoSymbol =:symbol")
    List<User> getUsersByCryptoSymbol(@Param("symbol") String symbol);
}
