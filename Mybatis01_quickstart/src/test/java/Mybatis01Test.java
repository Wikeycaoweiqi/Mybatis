import com.wikeystudy.mybatis.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ Author：Wikey Cao
 * @ Date：05-11-2024
 * @ Description：
 */
public class Mybatis01Test {
    @Test
    public void insertCarBySqlSessionUtil() {
        SqlSession sqlSession = SqlSessionUtil.openSeasion();
        int rows = sqlSession.insert("insertCar");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(rows);
    }
}