# Smart Floating Text Reader

A personal productivity Android app that reads visible text from any screen using Accessibility Service and Text-to-Speech.

## Features

- **Movable Floating Button** — Drag it anywhere on screen, stays above all apps
- **Screen Text Detection** — Uses Accessibility Service to detect all visible text
- **Smart Reading Order** — Reads top-to-bottom based on Y/X screen position
- **Tap-to-Read** — Tap any text element to jump reading there instantly
- **Text-to-Speech** — Natural voice with adjustable speed, pitch, and 30+ languages
- **Quick Menu** — Long-press the floating button for Start/Pause/Resume/Stop/Settings
- **Dark/Light Mode** — Full theme support
- **Reading Progress** — Visual progress bar with element counter

## Requirements

- **Android 7.0+ (API 24)**
- **Overlay Permission** — For the floating button
- **Accessibility Service** — For screen text detection

## Setup

1. Open the project in Android Studio
2. Build and run on your device
3. Grant **Overlay Permission** when prompted
4. Enable **Smart Floating Text Reader** in Accessibility Settings
5. Start the service from the main screen

## Controls

| Gesture | Action |
|---------|---------|
| Single tap on floating button | Start reading |
| Double tap on floating button | Pause / Resume |
| Long press on floating button | Open quick menu |
| Drag floating button | Move it around |
| Tap any text on screen | Jump reading to that point |

## Project Structure

Text read ````
app/src/main/java/com/smartreader/app/
├─ ├─━ SmartReaderApplication.kt          # Application class
├─└─ ━ service/
│   ├──── FloatingOverlayService.kt      # Floating button & overlay management
│   ├────━ ScreenReaderAccessibilityService.kt  # Accessibility service
├─└─ ━ tts/
│   └───━ TTSController.kt               # Text-to-Speech engine
├─└─ ━ ui/
│   ├──── MainActivity.kt                # Main screen
│   ├────━ SettingsActivity.kt            # Settings screen
└─└─ ━ utils/
    ├────━ PreferenceManager.kt           # SharedPreferences wrapper
    └──── ScreenTextElement.kt           # Data models & utilities
```

## Permissions

- `SYSTEM_ALERT_WINDOW` — Floating overlay button
- `BIND_ACCESSIBILITY_SERVICE` — Screen text detection
- `FOREGROUND_SERVICE` — Keep service alive
- `POST_NOTIFICATIONS` — Android 13+ notification channel
