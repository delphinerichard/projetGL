package app.businessObject;

import java.io.Serializable;

public abstract class Utilisateur implements Serializable {
        protected int idUtilisateur;
        private String nom;
        private String prenom;
        private String courriel;
        private String mdpHache;

        public Utilisateur(int idUtilisateur){
                this.idUtilisateur = idUtilisateur;
        }

        public Utilisateur(int idUtilisateur, String nom, String prenom, String courriel, String mdpHache) {
                this.idUtilisateur = idUtilisateur;
                this.nom = nom;
                this.prenom = prenom;
                this.courriel = courriel;
                this.mdpHache = mdpHache;
        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public String toStringloc() { //toString "local"
                return "Utilisateur{" +
                        "idUtilisateur=" + idUtilisateur +
                        ", nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", courriel='" + courriel + '\'' +
                        ',';
        }

        public int getIdUtilisateur() {
                return idUtilisateur;
        }

        public String getPrenom() {
                return prenom;
        }

        public String getMdpHache() {
                return mdpHache;
        }

        public String getCourriel() {
                return courriel;
        }

        public String getNom() {
                return nom;
        }

        public abstract String toStringChild();

        @Override
        public String toString() {
                return this.toStringloc() + this.toStringChild();
        }
}
