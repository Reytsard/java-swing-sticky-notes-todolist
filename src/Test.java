import model.DB;
import model.PRIORITY;
import model.Todo;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            DB db = new DB();
            db.insertTodo(new Todo("Title3", "akurgarngoanrhghardsognhljaksdfhjdfdornlaksjdurnnfkhghtlkskcsornktjsjysfpfontnslewieurhnv slkjfoaiuwjfh gvolgioutnntkkfjn vnnfjjfkdurijeoegjguithrnnmvhhvydiedhentkgjhthsl", PRIORITY.LOW));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
