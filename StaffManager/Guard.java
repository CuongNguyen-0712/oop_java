package StaffManager;

import feature.inputScanner;

class Guard extends Staff {

    private String martialArt;

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
       do {
           System.out.println("Nhap vo thuat cua bao ve :");
           martialArt = inputScanner.input.nextLine();
       } while (!martialArt.equalsIgnoreCase("Muay Thai")
               || !martialArt.equalsIgnoreCase("Vovinam")
               || !martialArt.equalsIgnoreCase("Boxing")
               || !martialArt.equalsIgnoreCase("Karate")
               || !martialArt.equalsIgnoreCase("Taekwondo")
               || !martialArt.equalsIgnoreCase("CQC")
               || !martialArt.equalsIgnoreCase("Capeoira")
               || !martialArt.equalsIgnoreCase("Judo")
               || !martialArt.equalsIgnoreCase("Jinjutsu")
               || !martialArt.equalsIgnoreCase("Wrestling")
               || !martialArt.equalsIgnoreCase("Kudo")
               || !martialArt.equalsIgnoreCase("Systema")
               || !martialArt.equalsIgnoreCase("Aikido")
               || !martialArt.equalsIgnoreCase("MMA")
               || !martialArt.equalsIgnoreCase("Kyoukshin Karate"));
    }
        @Override
        public void display () {

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
