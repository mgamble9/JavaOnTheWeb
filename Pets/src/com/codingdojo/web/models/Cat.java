package com.codingdojo.web.models;

public class Cat extends Animal implements Pet {

		public Cat(String n, String b, double w) {
			this.name = n;
			this.breed = b;
			this.weight = w;
		}

		@Override
		public String showAffection() {
			// TODO Auto-generated method stub
			return "Your " + breed + " cat " + name + ", looked at you and walked away.";
		}
		
}
