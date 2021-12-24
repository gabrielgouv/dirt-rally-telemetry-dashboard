<p align="center">
    <img src="docs/images/dr2td_dashboard.png" alt="Header">
</p>

# Telemetry Dashboard for DiRT Rally 2.0 (WIP)

### Displays

- Current gear
- Current Speed
- Steering wheel position
- Throttle, brake and clutch pedals input
- Engine RPM

### DiRT Rally 2.0 configuration

1. Go to `C:\Users\<USER>\Documents\My Games\DiRT Rally 2.0\hardwaresettings`;
2. Open `hardware_settings_config` with your favorite text editor;
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

### Installation
WIP

### Use
WIP

### Dashboard configuration
WIP