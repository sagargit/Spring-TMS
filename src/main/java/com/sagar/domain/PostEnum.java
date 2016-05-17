package com.sagar.domain;

import com.sagar.domain.PostEnum;

public enum PostEnum {
	 MANAGER(1), QC(2), DEVELOPER(3);
	    private int value;
	    private PostEnum(int x) {
	        this.value = x;
	    }

	    public int getValue() {
	        return value;
	    }

	    public static PostEnum getPostEnum(String fromClient) {  // static has to be used here
	        for (PostEnum p : PostEnum.values()) {
	            if (p.name().equalsIgnoreCase(fromClient)) {
	                return p;
	            }
	        }
	        return null;
	    }

	    public static PostEnum getPostEnum(int fromDAO) {
	        for (PostEnum p : PostEnum.values()) {
	            if (p.getValue() == fromDAO) {
	                return p;
	            }
	        }
	        return null;
	    }
	    
}
