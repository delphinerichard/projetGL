package app.message;

import app.businessObject.Candidat;

public class CandidatMessageVersClient extends Message {
        private Candidat candidat;
        private String SQLerr;

        public CandidatMessageVersClient(Candidat candidat, String SQLerr) {
            this.candidat = candidat;
            this.SQLerr = SQLerr;
        }

        public String getSQLerr() {
            return SQLerr;
        }

        public Candidat getCandidat() {
            return candidat;
        }

        @Override
        public String toString() {
            return "CandidatMessageVersClient{" +
                    "candidat='" + candidat + '\'' +
                    ", SQLerr='" + SQLerr + '\'' +
                    '}';
        }

}
