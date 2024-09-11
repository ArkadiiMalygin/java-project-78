.PHONY: build

build:
	./gradlew clean
	./gradlew checkstyleMain
	./gradlew checkstyleTest
	./gradlew test
	./gradlew jacocoTestReport
	./gradlew build

report:
	./gradlew jacocoTestReport