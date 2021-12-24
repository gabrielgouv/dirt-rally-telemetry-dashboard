<p align="center">
    <img src="docs/images/dr2td_dashboard.png" alt="Header">
</p>

# Telemetry Dashboard for DiRT Rally 2.0 (WIP)

## Displays

- Current gear
- Current speed
- Steering wheel position
- Throttle, brake and clutch pedals input
- Engine RPM

## DiRT Rally 2.0 configuration

1. Go to `C:\Users\<USER>\Documents\My Games\DiRT Rally 2.0\hardwaresettings`;
2. Open `hardware_settings_config` file with your favorite text editor;
3. Find for **udp** tag and configure as shown below:
      ```xml
      <motion_platform>
           ...
           <udp enabled="true" extradata="3" ip="127.0.0.1" port="10001" delay="1" />
           ...
       </motion_platform>
      ```
   - enabled = true
   - extradata = 3
   - port = 10001

## Download and Installation
### Latest version is: **[v0.1.0-alpha](https://github.com/gabrielgouv/dirt-rally-telemetry-dashboard/releases/tag/v0.1.0-alpha)**

To download other versions, go to the [releases page](https://github.com/gabrielgouv/dirt-rally-telemetry-dashboard/releases) and look for the specific version.

This application does not have an installer, just run the executable file.

### Use
WIP

### Dashboard configuration
WIP