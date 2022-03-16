package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Ramadan {

	
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column
		@Min(1)
		@Max(30)
		private int day;
		
		@Column(unique= true, nullable = false)
		private String Fajr;
		
		@Column
		private String Dhur;
		
		@Column
		private String asr ;
		
		@Column
		private String Maghrib ;
		
		@Column
		private String Isha ;
		
		public Ramadan () {}
		
		public Ramadan (@Min(1) @Max(30) int day,String fajr,String Dhur,String asr,String maghrib, String Isha) {
			this.day=day;
			this.Fajr=fajr;
			this.Dhur=Dhur;
			this.asr=asr;
			this.Maghrib=maghrib;
			this.Isha=Isha;
			
			
		
		}
//		Constructor for testing;
		public Ramadan (long id,@Min(1) @Max(30) int day,String fajr,String Dhur,String asr,String maghrib, String Isha) {
			this.id=id;
			this.day=day;
			this.Fajr=fajr;
			this.Dhur=Dhur;
			this.asr=asr;
			this.Maghrib=maghrib;
			this.Isha=Isha;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public String getFajr() {
			return Fajr;
		}

		public void setFajr(String fajr) {
			Fajr = fajr;
		}

		public String getDhur() {
			return Dhur;
		}

		public void setDhur(String dhur) {
			Dhur = dhur;
		}

		public String getAsr() {
			return asr;
		}

		public void setAsr(String asr) {
			this.asr = asr;
		}

		public String getMaghrib() {
			return Maghrib;
		}

		public void setMaghrib(String maghrib) {
			Maghrib = maghrib;
		}

		public String getIsha() {
			return Isha;
		}

		public void setIsha(String isha) {
			Isha = isha;
		}

		
		@Override
		public String toString() {
			return "Ramadan [id=" + id + ", day=" + day + ", Fajr=" + Fajr + ", Dhur=" + Dhur + ", asr=" + asr
					+ ", Maghrib=" + Maghrib + ", Isha=" + Isha + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(Dhur, Fajr, Isha, Maghrib, asr, day);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ramadan other = (Ramadan) obj;
			return Objects.equals(Dhur, other.Dhur) && Objects.equals(Fajr, other.Fajr)
					&& Objects.equals(Isha, other.Isha) && Objects.equals(Maghrib, other.Maghrib)
					&& Objects.equals(asr, other.asr) && day == other.day;
		}

		

	

		
		
		
		
		
		
}
		
