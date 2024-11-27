package StaffManager;

import feature.*;

import java.util.*;

class Guard extends Staff {

    private String martialArt;

    private static final HashSet<String> martialArtList = new HashSet<>();

    public Guard() {
    }

    public Guard(Staff newGuard, String martialArt) {
        super(newGuard);
        this.martialArt = martialArt;
    }

    public void setMA(String MA) {
        martialArt = MA;
    }

    @Override
    public void add() {
        super.add();
        martialArtList.add("Muay Thai");
        martialArtList.add("Vovinam");
        martialArtList.add("Boxing");
        martialArtList.add("Karate");
        martialArtList.add("Taekwondo");
        martialArtList.add("CQC");
        martialArtList.add("Capeoira");
        martialArtList.add("Judo");
        martialArtList.add("Jinjutsu");
        martialArtList.add("Wrestling");
        martialArtList.add("Kudo");
        martialArtList.add("Systema");
        martialArtList.add("Aikido");
        martialArtList.add("MMA");
        martialArtList.add("Kyoukshin Karate");
        do {
            System.out.print("Nhap vo thuat cua bao ve: ");
            martialArt = inputScanner.input.nextLine();
        } while (!martialArtList.contains(martialArt));
    }
        @Override
        public void display () {
            formatString.toStringTypeStaff(this.getID(), this.getName(), this.getSalary(), martialArt, "Vo thuat");
        }

        @Override
        public void work () {
            int extra = 0;
            switch (martialArt.toLowerCase()) {
                case "karate":
                case "judo":
                case "aikido":
                case "vovinam":
                    extra = 1;
                    break;
                case "taekwondo":
                case "boxing":
                case "wrestling":
                case "jinjutsu":
                    extra = 2;
                    break;
                case "kyoukshin karate":
                case "kudo":
                case "muay thai":
                case "cqc":
                case "systema":
                case "capeoira":
                case "mma":
                    extra = 3;
                    break;
            }
            setSalary(getSalary() * extra);
        }
        @Override
        public String getOwnAtributte () {
            return "Vo thuat";
        }
        @Override
        public void showUnique () {
            System.out.println("Vo thuat cu la : " + martialArt);
        }

    }
