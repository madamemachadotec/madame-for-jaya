package br.com.octoevents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.octoevents.dao.config.Conexao;
import br.com.octoevents.domain.Event;

public class EventDAO_Impl implements IEventDAO {

	@Override
	public int insert(Event event) {
		
		Conexao conexao= Conexao.getInstance();
		Connection con = conexao.getConnection();
		
		String sql ="insert into event(even_id, even_action, even_number, even_status, even_dt_hr_creation, even_dt_hr_update, even_title, even_user) values(?,?,?,?,?,?,?,?)";
		int resultado = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, event.getId());
			pst.setString(2, event.getAction());
			pst.setInt(3,event.getNumber());
			pst.setString(4, event.getStatus());
			pst.setTimestamp(5, new Timestamp(event.getDateTimeCreation().getTime()));
			pst.setTimestamp(6, new Timestamp(event.getDateTimeUpdated().getTime()));
			pst.setString(7, event.getTitle());
			pst.setString(8, event.getUser());
			resultado = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			conexao.closeConnection();
		}
		return resultado;
	}

	@Override
	public List<Event> findByNumber(int number) {
		List<Event> resultado = new ArrayList<Event>();
		Conexao conexao= Conexao.getInstance();
		Connection con = conexao.getConnection();
		String sql="select * from event e where e.even_number = ?" ;
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, number);
			
			ResultSet rs= pst.executeQuery();
			
			if(rs!=null){
				while(rs.next()){
					Event event = new Event();
					event.setId(rs.getInt("even_id"));
					event.setAction(rs.getString("even_action"));
					event.setNumber(rs.getInt("even_number"));
					event.setStatus(rs.getString("even_status"));
					event.setDateTimeCreation(rs.getTimestamp("even_dt_hr_creation"));
					event.setDateTimeUpdated(rs.getTimestamp("even_dt_hr_update"));
					event.setTitle(rs.getString("even_title"));
					event.setUser(rs.getString("even_user"));
					resultado.add(event);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conexao.closeConnection();
		}
		return resultado;
	}
}
