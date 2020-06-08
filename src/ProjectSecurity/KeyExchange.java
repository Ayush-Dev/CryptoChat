package ProjectSecurity;

import java.math.BigInteger;
import java.util.ArrayList;

public class KeyExchange {

//    private static final int N = 991, G = 997;
    private static final BigInteger N=new BigInteger("991");
    private static final BigInteger G=new BigInteger("997");

    /*It generates Private Key Packets*/
    public static String generatePrivateKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static ArrayList<Integer> generatePrivatePackets(String privateKey) {
        ArrayList<Integer> privateKeyPackets = new ArrayList();
        int s = 0;
        int i = (privateKey.length()) / 2;
        while (i > 0) {
            privateKeyPackets.add(Integer.parseInt(privateKey.substring(s, s + 2)));
            i--;
            s += 2;
        }
        if (s != privateKey.length()) {
            privateKeyPackets.add(Integer.parseInt(privateKey.substring(s)));
        }
        return privateKeyPackets;

    }

    /*It Generates Public Key Packets From Private Key Packets using DH Algorithm*/
    public static ArrayList<String> generatePublicPackets(ArrayList<Integer> privateKeyPackets) {
        ArrayList<String> publicKeyPackets = new ArrayList();
        for (int i = 0; i < privateKeyPackets.size(); i++) {
//            publicKeyPackets.add(String.valueOf((int) (Math.pow(G, privateKeyPackets.get(i)) % N)));
            publicKeyPackets.add(String.valueOf((G.pow(privateKeyPackets.get(i))).mod(N)));
        }
        return publicKeyPackets;
    }

    public static ArrayList<Integer> generatePublicPackets(String publicKey) {
        ArrayList publicKeyPackets = new ArrayList();
        int s = 0;
        int i = (publicKey.length()) / 3;
        while (i > 0) {
            publicKeyPackets.add(Integer.parseInt(publicKey.substring(s, s + 3)));
            i--;
            s += 3;
        }
        if (s != publicKey.length()) {
            publicKeyPackets.add(Integer.parseInt(publicKey.substring(s)));
        }
        return publicKeyPackets;
    }

    public static String generatePublicKey(ArrayList<String> publicKeyPackets) {
        StringBuilder publicKey = new StringBuilder();
        for (int i = 0; i < publicKeyPackets.size(); i++) {
            while(publicKeyPackets.get(i).length()!=3){
                publicKeyPackets.set(i, "0"+publicKeyPackets.get(i));
            }
            publicKey.append(publicKeyPackets.get(i));
        }
        return publicKey.toString();
    }

    public static ArrayList<Integer> generateSharedPackets(ArrayList<Integer> publicKeyPackets, ArrayList<Integer> privateKeyPackets) {
        ArrayList<Integer> sharedKeyPackets = new ArrayList();
        for (int i = 0; i < publicKeyPackets.size(); i++) {
//            sharedKeyPackets.add((int) (Math.pow(publicKeyPackets.get(i), privateKeyPackets.get(i))) % N);
            sharedKeyPackets.add(Integer.parseInt(String.valueOf(((new BigInteger(String.valueOf(publicKeyPackets.get(i)))).pow(privateKeyPackets.get(i))).mod(N))));
        }
        return sharedKeyPackets;
    }

    public static String generateSharedKey(ArrayList<Integer> sharedKeyPackets) {
        StringBuilder sharedKey = new StringBuilder();
//        sharedKey.append("!@#$");                                               //salting
        for (int i = 0; i < sharedKeyPackets.size(); i++) {
            sharedKey.append(sharedKeyPackets.get(i));
        }
//        sharedKey.append("%^&*");                                               //salting
        return sharedKey.toString();
    }
}
