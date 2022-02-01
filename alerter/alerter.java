public class Alerter {
    static int alertFailureCount = 0;
    static int networkAlertStub(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius");
        // Return 200 for ok
        // stub always succeeds and returns 200
        return 200;
    }
    
    static int networkNotOkStub(float celcius) {
        System.out.println("Temperature in Network - 'Not Ok' is " + celcius + " celcius");
        // Return 500 for not-ok
        // stub always succeeds and returns 500
        return 500;
    }
    static void alertInCelcius(float farenheit, String networkTempStatus) {
        float celcius = convertFarenheitToCelcius(farenheit);
        int returnCode =resolveNetworkAlert(networkTempStatus);
        incrementFailureCount(returnCode);
    }
    static int resolveNetworkAlert(String networkTempStatus){
        return networkTempStatus=="ok" ? networkAlertStub(celcius) : networkNotOkStub(celcius);
      }
    static float convertFarenheitToCelcius(float farenheit){
       return  (farenheit - 32) * 5 / 9;
    }
    static void incrementFailureCount(String returnCode){
        if (returnCode != 200) {
            alertFailureCount += 1;
        }
    }
    public static void main(String[] args) {
        alertInCelcius(400.5f,"ok");
        assert( 0==alertFailureCount);
        alertInCelcius(303.6f,"not ok");
        assert(1==alertFailureCount);
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        assert(resolveNetworkAlert("ok")==200);
        assert(resolveNetworkAlert("not ok")==500);
        assert(convertFarenheitToCelcius(100)==37.78);
        assert(incrementFailureCount(200)==2);
        assert(incrementFailureCount(500)==2);
        
        System.out.println("All is well (maybe!)\n");
    }
}
