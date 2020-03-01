import java.sql.*;

public class ObslugaDB {

	protected static Connection createConnection() {
		String url = "jdbc:mysql://localhost:3306/java?useUnicode=true&amp;characterEncoding=UTF-8";
		String user = "java";
		String password = "java";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
		return null;
	}

	public static void dodajDoDB(Connection conn, String imie, String nazwisko, String wiek) {
		try {
			int wi = Integer.parseInt(wiek);
			Statement st = conn.createStatement();
			String zapytanie = "insert into uczniowie (imie, nazwisko, wiek) values('" + imie + "', '" + nazwisko + "',"
					+ wi + ") ";
			st.executeUpdate(zapytanie);
			conn.close();
			System.out.println("tak");
		} catch (Exception exc) {
			System.out.println("nie");
			exc.printStackTrace();
		}
	}

	public static void usunZDB(Connection conn, String lp1) {
		try {
			int lp = Integer.parseInt(lp1);
			Statement st = conn.createStatement();
			String zapytanie = "delete from uczniowie where lp = '" + lp + "'";
			st.executeUpdate(zapytanie);
			conn.close();
			System.out.println("tak");
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("nie");
		}
	}

	public static String[] uczniowieZDB(Connection conn) {
		try {
			Statement st = conn.createStatement();
			String zapytanie = "select * from uczniowie order by lp asc";
			ResultSet rs = st.executeQuery(zapytanie);
			String[] uczniowie = new String[20];
			int i = 0;
			while (rs.next()) {
				String lp1 = rs.getString("lp");
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				String wiek = rs.getString("wiek");
				uczniowie[i] = lp1 + ": " + imie + "-" + nazwisko + "-" + wiek;
				i++;
			}
			conn.close();
			return uczniowie;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
