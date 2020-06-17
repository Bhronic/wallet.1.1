package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="UserLogs")
	public class Admin {

		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
		
		private String userName;
		
		private String dateandtime;
		
		private String activity;

		public String getActivity() {
			return activity;
		}

		public void setActivity(String activity) {
			this.activity = activity;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getDateandtime() {
			return dateandtime;
		}

		public void setDateandtime(String dateandtime) {
			this.dateandtime = dateandtime;
		}
		
}
