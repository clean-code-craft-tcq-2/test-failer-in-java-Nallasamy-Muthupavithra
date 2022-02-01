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
        float celcius = (farenheit - 32) * 5 / 9;
        int returnCode = networkTempStatus=="ok"?networkAlertStub(celcius):networkNotOkStub(celcius);
        if (returnCode != 200) {
            alertFailureCount += 1;
        }
    }
    public static void main(String[] args) {
        alertInCelcius(400.5f,"ok");
        assertEquals("Failures count is not right", 0,alertFailureCount);
        alertInCelcius(303.6f,"not ok");
        assertEquals("Failures count is not right", 1,alertFailureCount);
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }
}
