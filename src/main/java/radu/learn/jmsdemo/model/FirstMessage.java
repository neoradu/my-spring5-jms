package radu.learn.jmsdemo.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
public class FirstMessage implements Serializable {
	private static final long serialVersionUID = -2882504109336276750L;
	private UUID uuid;
	private String message;
	public FirstMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FirstMessage(UUID uuid, String message) {
		super();
		this.uuid = uuid;
		this.message = message;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "FirstMessage [uuid=" + uuid + ", message=" + message + "]";
	}
	
}
