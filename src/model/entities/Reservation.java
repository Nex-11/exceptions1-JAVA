package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// ESTE ARGUMENTO ESTÁ ESTÁTICO PARA NÃO SER INSTANCIADO SEMPRE QUE FOR USADO OBJETO
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	// METODO PARA CALCULAR A DURAÇÃO DA ESTADIA 
	public long duration() {
		// CALCULO PARA SABER O TEMPO DE DURAÇÃO DA ESTADIA
		long diff = checkOut.getTime() - checkIn.getTime();
		// METODO PARA TRANSFORMAR MILISEGUNDOS EM DIAS
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	// METODO PARA DAR UPDATE AS DATAS
	public String updateDates(Date checkIn, Date checkOut) {
		// COLOCADA A EXCEÇÃO NO METODO "updateDates" NA CLASSE "Reservation"
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in Reservation: Check-out date must be after check-in date.";
		}
		if (!checkOut.after(checkIn)){
			return "Error in Reservation: Check-out date must be after check-in date.";		
		}
		// PASSAR OS VALORES PASSADOS POR ARGUMENTO PARA OS PARAMETROS DO OBJETO
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		}
	
	@Override
	public String toString() {
		return "Room " 
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nigths";
	}
	
	
	

	
	

}
