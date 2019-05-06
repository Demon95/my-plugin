import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.sql.*;

public class Main extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project project = e.getProject();
        try {
            mysql();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Messages.showMessageDialog(project, "Hello world!", "Greeting", Messages.getInformationIcon());
    }

    public void mysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql?useSSL=FALSE&serverTimezone=UTC","root", "123456");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select*from user");
        while (rs.next()) {
            for (int i = 1; i <= 4; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}
