import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Mounika_Golla
 *
 */
public class Dao {

	/* Constructor */
	public Dao() {
		createTable();
	}

	/* Connect to Database */
	private Connection getConnection() {
		String url = "jdbc:sqlite:todoitems.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;

	}

	/* Create table if not already created */
	private void createTable() {
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			stmt.execute(
					"CREATE TABLE IF NOT EXISTS ToDoItem (ID INTEGER PRIMARY KEY AUTOINCREMENT, DESCRIPTION varchar(255),STATUS varchar(255)); ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/*
	 * Add todoItem to Database.
	 */
	public void add(String description, String completionFlag) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = null;
		String insertTodoItem = "INSERT INTO ToDoItem(DESCRIPTION,STATUS) VALUES (?,?)";
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement(insertTodoItem);
			stmt.setString(1, description);
			stmt.setString(2, completionFlag);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/*
	 * Update status for a todoitem
	 */
	public void update(ToDoItem entry) throws SQLException {
		String updateStatement = "UPDATE ToDoItem SET STATUS = ? WHERE ID = ?";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement(updateStatement);
			stmt.setString(1, entry.getCompletedFlag());
			stmt.setInt(2, entry.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/*
	 * Deletes a todoItem
	 */
	public void delete(ToDoItem entry) throws SQLException {
		String deleteStatement = "DELETE FROM ToDoItem WHERE ID = ?";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement(deleteStatement);
			stmt.setInt(1, entry.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/*
	 * Retrieve a todoitem for a given Id
	 */
	public ToDoItem get(int id) throws SQLException {
		ToDoItem toDoItem = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String selectStatement = "SELECT ID, DESCRIPTION,STATUS from ToDoItem WHERE ID = ?";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(selectStatement);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String description = rs.getString("DESCRIPTION");
				String completedFlag = rs.getString("STATUS");
				toDoItem = new ToDoItem(id, description, completedFlag);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return toDoItem;
	}

	/*
	 * Get all todoitems for given status
	 */
	public List<ToDoItem> list(String status) throws SQLException {
		List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String selectStatement = "SELECT ID, DESCRIPTION,STATUS from ToDoItem WHERE STATUS = ?";
			conn = this.getConnection();
			pstmt = conn.prepareStatement(selectStatement);
			pstmt.setString(1, status);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String description = rs.getString("DESCRIPTION");
				String completedFlag = rs.getString("STATUS");
				toDoItems.add(new ToDoItem(id, description, completedFlag));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return toDoItems;
	}

	/*
	 * Get all todoitems
	 */
	public List<ToDoItem> listAll() throws SQLException {
		List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		try {
			String selectStatement = "SELECT ID, DESCRIPTION,STATUS from ToDoItem";
			conn = this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectStatement);
			while (rs.next()) {
				toDoItems.add(new ToDoItem(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getString("STATUS")));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return toDoItems;
	}

}
