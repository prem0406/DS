package com.codingblocks.Recursion;

public class FriendPairing {

	public static void main(String[] args) {
		System.out.println(friend_pairing(2));

	}
	public static int friend_pairing(int n) {
		if (n == 1 || n == 2) {
			return n;
		}

		int s = friend_pairing(n - 1);
		int d = (n - 1) * friend_pairing(n - 2);

		return s + d;
	}

}
