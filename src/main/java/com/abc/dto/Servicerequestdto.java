package com.abc.dto;

import java.io.Serializable;

public class Servicerequestdto implements Serializable {
	
	//private static final long serialVersionUID = 8336749435408801262L;
		private int servicerequestid;
		private String status;
		
		public int getServicerequestid() {
			return servicerequestid;
		}
		public void setServicerequestid(int servicerequestid) {
			this.servicerequestid = servicerequestid;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

}
