package edu.mccc.cos210.sp2016.ds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.CRC32;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JPanel;

public class HashTest {
	private static final int N = 1000;
	private static double loadFactor = 0.75;
	private static final int NUMBER_OF_ELEMENTS = (int) (N * loadFactor);
	private int[] bucketArray1 = new int[N];
	private int[] bucketArray2 = new int[N];
	private int[] bucketArray3 = new int[N];
	private int maxCollision1;
	private int maxCollision2;
	private int maxCollision3;
	private int unusedBuckets1;
	private int unusedBuckets2;
	private int unusedBuckets3;
	public static void main(String[] sa) {
		int collisionsum1 = 0;
		int collisionsum2 = 0;
		int collisionsum3 = 0;
		int emptysum1 = 0;
		int emptysum2 = 0;
		int emptysum3 = 0;
		
		int runs = 1000;
		for (int i = 0; i < runs; i++) {
			HashTest test = new HashTest();
			test.doIt();
			collisionsum1 += test.maxCollision1;
			collisionsum2 += test.maxCollision2;
			collisionsum3 += test.maxCollision3;
			emptysum1 += test.unusedBuckets1;
			emptysum2 += test.unusedBuckets2;
			emptysum3 += test.unusedBuckets3;
		}
		System.out.printf("Random:\nAvg Collisions:%.3f Avg Empty:%.3f\n",(double) collisionsum1 / runs, (double)emptysum1 / runs);
		System.out.printf("Test: \nAvg Collisions:%.3f Avg Empty:%.3f\n", (double) collisionsum2 / runs, (double) emptysum2 / runs);
		System.out.printf("Simple:\nAvg Collisions:%.3f Avg Empty:%.3f\n", (double) collisionsum3 / runs, (double) emptysum3 / runs);
	}
	private void doIt() {
		unusedBuckets1 = 0;
		unusedBuckets2 = 0;
		unusedBuckets3 = 0;
		maxCollision1 = 0;
		List<JPanel> jps = getJPanels();
		List<String> words = getWords();
		int worst = 0;
		for (String word : words) {
			int index1 = compress1(hash(word));
			int collisions = 0;
			/*for (int i = 1; bucketArray[index]!= 0; i++) {
				index = Math.abs(compress(hash(word))+i) % N ;
				maxCollision++;
				collisions++;
			}*/
			bucketArray1[index1]++;
			worst = Math.max(worst, collisions);
		}
		//for (String word : words) {
		for (String word : words) {
			int index2 = compress2(hash(word));
			bucketArray2[index2]++;
		}
		for (String word : words) {
			int index3 = compress3(hash(word));
			bucketArray3[index3]++;
		}
		for (int i = 0; i < N; i++) {
			int count1 = bucketArray1[i];
			int count2 = bucketArray2[i];
			int count3 = bucketArray3[i];
			if (count1 == 0) {
				unusedBuckets1++;
			}
			if (count2 == 0) {
				unusedBuckets2++;
			}
			if (count3 == 0) {
				unusedBuckets3++;
			}
			maxCollision1 = Math.max(maxCollision1, count1);
			maxCollision2 = Math.max(maxCollision2, count2);
			maxCollision3 = Math.max(maxCollision3, count3);
			//System.out.printf("%d %d\n", i, count);
		}
		//System.out.println(worst);
		//System.out.printf("count=%d N=%d loadFactor=%.2f unused=%d maxCollisions=%d\n", NUMBER_OF_ELEMENTS, N, loadFactor, unusedBuckets, maxCollision);
	}
	private int compress1(int hashCode) {
		return (int) (Math.random() * N);
	}
	private int compress2(int hashCode) {
		int original = Math.abs(hashCode);
		hashCode=((Math.abs(15485867 * hashCode) + 3)% 32452843);
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
	    hashCode ^= (hashCode>>> 7) ^ (hashCode>>> 4);
	    hashCode=((Math.abs(15485867 * hashCode) + 3)% 32452843);
		return (hashCode % N + original % N) % N;
	}
	private int compress3(int hashCode) {
		return Math.abs(hashCode) % N;
	}
	private int hash(Object data) {
		CRC32 crc = new CRC32();
		crc.update(data.toString().getBytes());
		return (int) (crc.getValue());
		//return data.hashCode();
	}
	private List<String> getWords() {
		List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("./pocket.dic"))) {
			String s = "";
			while ((s = br.readLine()) != null) {
				list.add(s);
			}
		} catch (Exception ex) {
			System.err.println(ex);
			System.exit(-1);
		}
		Collections.shuffle(list);
		//Collections.sort(list);
		List<String> shortList = new ArrayList<>();
		int count = 0;
		for (String s : list) {
			if (count++ < NUMBER_OF_ELEMENTS) {
				shortList.add(s);
			}
		}
		return shortList;
	}
	private List<JPanel> getJPanels() {
		List<JPanel> list = new ArrayList<JPanel>();
		for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			list.add(new JPanel());
		}
		return list;
	}
}
