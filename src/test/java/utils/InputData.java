package utils;

public enum InputData {
        HOMEPAGE_URL("https://gmail.com/"),
        LOGINNAME("dashenka.anisimova.2000@gmail.com"),
        PASSWORD("Passw0rd2020"),
        SENDTOADRESS("dashenka.anisimova.2000@gmail.com");

        String personalData;

        InputData(String personalData) {

            this.personalData = personalData;
        }

        public String getPersonalData(){

            return personalData;
        }
}
