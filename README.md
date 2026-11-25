# ЛР4. Intent Extras

Мокринский, Малахов, Ершова. Группа МИБ-2512.

## Реализация

Два поля передаются на `Activity2` через `Intent.putExtra`. Ответ из второго экрана возвращается через `setResult` и Activity Result API; читается через `getStringExtra`. Кнопка «Назад» возвращает без нового ответа.

## Открытие и сборка

Откройте именно папку `Lab4` через File → Open в Android Studio и дождитесь Gradle Sync. Выберите модуль `app`, эмулятор/устройство с API 26 или новее и нажмите Run.

Стек: Kotlin 2.1.20, Android Gradle Plugin 8.9.2, Gradle Wrapper 8.14, JDK 17, compileSdk/targetSdk 35, minSdk 26. XML-разметка и View Binding. API 26 соответствует Android 8.0; подпись Android 6.0 в методичке ошибочна.

На этом компьютере JDK и SDK настроены. При переносе обновите `sdk.dir` в `local.properties`, `org.gradle.java.home` в `gradle.properties` и Gradle JDK в Android Studio.

```powershell
$env:JAVA_HOME = 'C:\Users\NuaghtyDragon\.jdks\ms-17.0.19'
.\gradlew.bat assembleDebug lintDebug
# Требуется запущенный эмулятор или подключённое устройство:
.\gradlew.bat connectedDebugAndroidTest
```

APK: `app/build/outputs/apk/debug/app-debug.apk`.
Отчёт UI-тестов: `app/build/reports/androidTests/connected/debug/index.html`.

## Проверка перед защитой

1. Введите два текста на первом экране и передайте их.
2. Проверьте оба текста на втором экране.
3. Введите ответ и нажмите «Вернуть ответ».
4. Проверьте ответ на первом экране и сохранение после поворота.

Исходники: `app/src/main/java/ru/mib2512/lab4`; разметки и строки: `app/src/main/res`. Фамилии и группа находятся в `values/strings.xml`. Автоматические сценарии — в `app/src/androidTest`.

Парольная схема учебная и повторяет методичку; SharedPreferences не шифрует пароль.
