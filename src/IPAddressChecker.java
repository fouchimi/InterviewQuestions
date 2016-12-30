/**
 * Created by ousmane on 12/27/16.
 */
public class IPAddressChecker {

    public void checkIpAddress(String str){
        String[] chunks = null;
        if(str.contains(".")){
            //Check for IPv4
            chunks = str.split("\\.");
            if(isValidIPv4(chunks)){
                System.out.println("IPv4");
            }else {
                System.out.println("Neither");
            }
        }else if(str.contains(":")){
            //Check for Ipv6
            chunks = str.split(":");
            if(isValidIPv6(chunks)){
                System.out.println("IPv6");
            }else {
                System.out.println("Neither");
            }
        }
    }

    private boolean isValidIPv4(String[] chunks){
        boolean flag = true;
        for(String chunk : chunks){
            if(chunk.matches("[0-9]+") && chunk.length() < 4){
                if(chunk.charAt(0) != '0' && Integer.parseInt(chunk) < 256){
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }else return false;
        }

        return flag;
    }

    private boolean isValidIPv6(String[] chunks){
        for(String chunk : chunks){
            if(chunk.matches("[0-9a-zA-Z]+") && chunk.length() < 5 && !chunk.isEmpty()){
                continue;
            }else return false;
        }
        return true;
    }

    public static void main(String[] args){
        IPAddressChecker ipAddressChecker = new IPAddressChecker();
        ipAddressChecker.checkIpAddress("172.16.254.1");
        ipAddressChecker.checkIpAddress("172.16.254.01");
        ipAddressChecker.checkIpAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        ipAddressChecker.checkIpAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334");
        ipAddressChecker.checkIpAddress("2001:0db8:85a3::8A2E:0370:7334");
        ipAddressChecker.checkIpAddress("256.256.256.256");
    }
}
