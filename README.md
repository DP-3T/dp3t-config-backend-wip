# SwissCovid Config Backend

SwissCovid is the official contact tracing app of Switzerland. The app can be installed from the [App Store](https://apps.apple.com/ch/app/swisscovid/id1509275381) or the [Google Play Store](https://play.google.com/store/apps/details?id=ch.admin.bag.dp3t). The SwissCovid 2.0 app uses two types of contact tracing to prevent the spread of COVID-19.

With proximity tracing close contacts are detected using the bluetooth technology. For this the [dp3t-sdk-backend](https://github.com/DP-3T/dp3t-sdk-backend), [DP3T iOS SDK](https://github.com/DP-3T/dp3t-sdk-ios) and [DP3T Android SDK](https://github.com/DP-3T/dp3t-sdk-android) are used that build on top of the Google & Apple Exposure Notifications. This feature is called SwissCovid encounters.

With presence tracing people that are at the same venue at the same time are detected. For this the [swisscovid-cn-backend](https://github.com/SwissCovid/swisscovid-cn-backend), [CrowdNotifier iOS SDK](https://github.com/CrowdNotifier/crowdnotifier-sdk-ios) and [CrowdNotifier Android SDK](https://github.com/CrowdNotifier/crowdnotifier-sdk-android) are used that provide a secure, decentralized, privacy-preserving presence tracing system. This feature is called SwissCovid Check-in.

## Description

This backend is used by the apps to get their config every 6h. It is used by the Swiss Government to update the 
epidemiological parameters if needed.

The following endpoints are available:

- `/v1` - returns `Hello from DP3T Config WS`
- `/v1/config` - returns a `ConfigResponse` with the following structure and default values:
  - `InfoBoxCollection` - empty by default
    - `deInfoBox` `InfoBox`
      - `title` `String`
      - `msg` `String`
      - `url` `String`
      - `urlTitle` `String`
      - `isDismissible = false`
    - `frInfoBox` `InfoBox`
    - `itInfoBox` `InfoBox`
    - `enInfoBox` `InfoBox`
    - `ptInfoBox` `InfoBox`
    - `esInfoBox` `InfoBox`
    - `sqInfoBox` `InfoBox`
    - `bsInfoBox` `InfoBox`
    - `hrInfoBox` `InfoBox`
    - `srInfoBox` `InfoBox`
    - `rmInfoBox` `InfoBox`
  - `SDKConfig` - will soon be removed (30/7/2020)
    - `numberOfWindowsForExposure = 3`
    - @Deprecated `eventThreshold = 0.8f`
    - @Deprecated `badAttenuationThreshold = 73.0f`
    - `contactAttenuationThreshold = 73.0f`
  - iOSGaenSdkConfig `GAENSDKConfig`
    - `lowerThreshold = 53`
    - `higherThreshold = 60`
    - `factorLow = 1.0d`
    - `factorHigh = 0.5d`
    - `triggerThreshold = 15`
  - androidGaenSdkConfig `GAENSDKConfig`
- `/v1/testinfobox/config` - returns a `ConfigResponse` with only the `SDKConfig` set to a static message

## /config special actions

The call to `/v1/config` does the following special actions:
1. `If iOS == 13.6`: warn that the German 'no risk' message is misleading
1. `If App == Testflight`: warn that the app should be updated to the official app-store app
1. `If App == Initial iOS test app`: set `factorHigh` = `0` to avoid errors

## Repositories

- Android App: [swisscovid-app-android](https://github.com/SwissCovid/swisscovid-app-android)
- iOS App: [swisscovid-app-ios](https://github.com/SwissCovid/swisscovid-app-ios)
- CovidCode Web-App: [CovidCode-UI](https://github.com/admin-ch/CovidCode-UI)
- CovidCode Backend: [CovidCode-Service](https://github.com/admin-ch/CovidCode-service)
- Config Backend: [swisscovid-config-backend](https://github.com/SwissCovid/swisscovid-config-backend)
- Additional Info Backend: [swisscovid-additionalinfo-backend](https://github.com/SwissCovid/swisscovid-additionalinfo-backend)
- QR Code Landingpage: [swisscovid-qr-landingpage](https://github.com/SwissCovid/swisscovid-qr-landingpage)
- DP3T Android SDK & Calibration app: [dp3t-sdk-android](https://github.com/DP-3T/dp3t-sdk-android)
- DP3T iOS SDK & Calibration app: [dp3t-sdk-ios](https://github.com/DP-3T/dp3t-sdk-ios)
- DP3T Backend SDK: [dp3t-sdk-backend](https://github.com/DP-3T/dp3t-sdk-backend)
- CrowdNotifier Android SDK: [crowdnotifier-sdk-android](https://github.com/CrowdNotifier/crowdnotifier-sdk-android)
- CrowdNotifier iOS SDK: [crowdnotifier-sdk-ios](https://github.com/CrowdNotifier/crowdnotifier-sdk-ios)
- CrowdNotifier Backend: [swisscovid-cn-backend](https://github.com/SwissCovid/swisscovid-cn-backend)

## License

This project is licensed under the terms of the MPL 2 license. See the [LICENSE](LICENSE) file.
