public class Alerter {
   static int alertFailureCount = 0;

  static int networkAlertStub(final float celcius) {
    System.out.println("ALERT: Temperature is " + celcius + " celcius");
    // Return 200 for ok
    // stub always succeeds and returns 200
    return 200;
  }

  static int networkNotOkStub(final float celcius) {
    System.out.println("Temperature in Network - 'Not Ok' is " + celcius + " celcius");
    // Return 500 for not-ok
    // stub always succeeds and returns 500
    return 500;
  }

  static void alertInCelcius(final float farenheit, final String networkTempStatus) {
    float celcius = convertFarenheitToCelcius(farenheit);
    int returnCode = resolveNetworkAlert(networkTempStatus, celcius);
    incrementFailureCount(returnCode);
  }

  static int resolveNetworkAlert(final String networkTempStatus, final float celcius) {
    return networkTempStatus == "ok" ? networkAlertStub(celcius) : networkNotOkStub(celcius);
  }

  static float convertFarenheitToCelcius(final float farenheit) {
     System.out.println("In celcius" + ((farenheit - 32) * 5) / 9 ) ;
    return ((farenheit - 32) * 5) / 9;
  }

  static void incrementFailureCount(final int returnCode) {
    if (returnCode != 200) {
      alertFailureCount += 1;
    }
  }

  public static void main(final String[] args) {
    alertInCelcius(400.5f, "ok");
    assert (0 == alertFailureCount);
    alertInCelcius(303.6f, "not ok");
    assert (1 == alertFailureCount);
    System.out.printf("%d alerts failed.\n", alertFailureCount);
    assert (resolveNetworkAlert("ok", 38) == 200);
    assert (resolveNetworkAlert("not ok", 98) == 500);
    assert (convertFarenheitToCelcius(100) == 37.77778);
    incrementFailureCount(200);
    assert (2 == alertFailureCount);
    incrementFailureCount(500);
    assert (2 == alertFailureCount);

    System.out.println("All is well (maybe!)\n");
  }
}
