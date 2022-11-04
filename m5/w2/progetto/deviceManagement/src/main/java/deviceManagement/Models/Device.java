package deviceManagement.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "devices")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private DeviceType deviceType;

	@Enumerated(EnumType.STRING)
	private DeviceStatus deviceStatus;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@JsonManagedReference
	private User user;

	public Device(DeviceType deviceType, DeviceStatus deviceStatus) {
		this.deviceType = deviceType;
		this.deviceStatus = deviceStatus;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", deviceType=" + deviceType + ", deviceStatus=" + deviceStatus + ", user=" + user
				+ "]";
	}

}
