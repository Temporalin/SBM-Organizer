package model.request;

import model.model.TournamentType;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 1:02 AM
 */
public class UpdateTournamentRequest {
    private final String originalUrlPath;
    private final String name;
    private final TournamentType type;
    private final String urlPath;
    private final String subdomain;
    private final String description;
    private final Boolean openSignup;
    private final Boolean holdThirdPlaceMatch;
    private final Double pointsForMatchWin;
    private final Double pointsForMatchTie;
    private final Double pointsForGameWin;
    private final Double pointsForGameTie;
    private final Double pointsForBye;
    private final Integer swissRounds;
    private final String rankedBy;
    private final Double rrPointsForMatchWin;
    private final Double rrPointsForMatchTie;
    private final Double rrPointsForGameWin;
    private final Double rrPointsForGameTie;
    private final Boolean acceptAttachments;
    private final Boolean hideForum;
    private final Boolean showRounds;
    private final Boolean privat;
    private final Boolean notifyUsersWhenMatchesOpen;
    private final Boolean notifyUsersWhenTheTournamentEnds;
    private final Boolean sequentialPairings;

    public UpdateTournamentRequest(String originalUrlPath, String name, TournamentType type, String urlPath,
                                   String subdomain, String description, Boolean openSignup,
                                   Boolean holdThirdPlaceMatch, Double pointsForMatchWin,
                                   Double pointsForMatchTie, Double pointsForGameWin,
                                   Double pointsForGameTie, Double pointsForBye, Integer swissRounds,
                                   String rankedBy, Double rrPointsForMatchWin, Double rrPointsForMatchTie,
                                   Double rrPointsForGameWin, Double rrPointsForGameTie,
                                   Boolean acceptAttachments, Boolean hideForum, Boolean showRounds,
                                   Boolean privat, Boolean notifyUsersWhenMatchesOpen,
                                   Boolean notifyUsersWhenTheTournamentEnds, Boolean sequentialPairings) {
        this.originalUrlPath = originalUrlPath;
        this.name = name;
        this.type = type;
        this.urlPath = urlPath;
        this.subdomain = subdomain;
        this.description = description;
        this.openSignup = openSignup;
        this.holdThirdPlaceMatch = holdThirdPlaceMatch;
        this.pointsForMatchWin = pointsForMatchWin;
        this.pointsForMatchTie = pointsForMatchTie;
        this.pointsForGameWin = pointsForGameWin;
        this.pointsForGameTie = pointsForGameTie;
        this.pointsForBye = pointsForBye;
        this.swissRounds = swissRounds;
        this.rankedBy = rankedBy;
        this.rrPointsForMatchWin = rrPointsForMatchWin;
        this.rrPointsForMatchTie = rrPointsForMatchTie;
        this.rrPointsForGameWin = rrPointsForGameWin;
        this.rrPointsForGameTie = rrPointsForGameTie;
        this.acceptAttachments = acceptAttachments;
        this.hideForum = hideForum;
        this.showRounds = showRounds;
        this.privat = privat;
        this.notifyUsersWhenMatchesOpen = notifyUsersWhenMatchesOpen;
        this.notifyUsersWhenTheTournamentEnds = notifyUsersWhenTheTournamentEnds;
        this.sequentialPairings = sequentialPairings;
    }

    public String getOriginalUrlPath() {
        return originalUrlPath;
    }

    public String getName() {
        return name;
    }

    public TournamentType getType() {
        return type;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isOpenSignup() {
        return openSignup;
    }

    public Boolean isHoldThirdPlaceMatch() {
        return holdThirdPlaceMatch;
    }

    public Double getPointsForMatchWin() {
        return pointsForMatchWin;
    }

    public Double getPointsForMatchTie() {
        return pointsForMatchTie;
    }

    public Double getPointsForGameWin() {
        return pointsForGameWin;
    }

    public Double getPointsForGameTie() {
        return pointsForGameTie;
    }

    public Double getPointsForBye() {
        return pointsForBye;
    }

    public Integer getSwissRounds() {
        return swissRounds;
    }

    public String getRankedBy() {
        return rankedBy;
    }

    public Double getRrPointsForMatchWin() {
        return rrPointsForMatchWin;
    }

    public Double getRrPointsForMatchTie() {
        return rrPointsForMatchTie;
    }

    public Double getRrPointsForGameWin() {
        return rrPointsForGameWin;
    }

    public Double getRrPointsForGameTie() {
        return rrPointsForGameTie;
    }

    public Boolean isAcceptAttachments() {
        return acceptAttachments;
    }

    public Boolean isHideForum() {
        return hideForum;
    }

    public Boolean isShowRounds() {
        return showRounds;
    }

    public Boolean isPrivate() {
        return privat;
    }

    public Boolean isNotifyUsersWhenMatchesOpen() {
        return notifyUsersWhenMatchesOpen;
    }

    public Boolean isNotifyUsersWhenTheTournamentEnds() {
        return notifyUsersWhenTheTournamentEnds;
    }

    public Boolean isSequentialPairings() {
        return sequentialPairings;
    }

    public static class Builder {
        private final String originalUrlPath;
        private String name;
        private TournamentType type;
        private String urlPath;
        private String subdomain;
        private String description;
        private Boolean openSignup;
        private Boolean holdThirdPlaceMatch;
        private Double pointsForMatchWin;
        private Double pointsForMatchTie;
        private Double pointsForGameWin;
        private Double pointsForGameTie;
        private Double pointsForBye;
        private Integer swissRounds;
        private String rankedBy;
        private Double rrPointsForMatchWin;
        private Double rrPointsForMatchTie;
        private Double rrPointsForGameWin;
        private Double rrPointsForGameTie;
        private Boolean acceptAttachments;
        private Boolean hideForum;
        private Boolean showRounds;
        private Boolean privat;
        private Boolean notifyUsersWhenMatchesOpen;
        private Boolean notifyUsersWhenTheTournamentEnds;
        private Boolean sequentialPairings;

        public Builder(final String originalUrlPath) {
            this.originalUrlPath = originalUrlPath;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withTournamentType(TournamentType type) {
            this.type = type;
            return this;
        }

        public Builder withUrlPath(String urlPath) {
            this.urlPath = urlPath;
            return this;
        }

        public Builder withSubdomain(String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder doOpenSignup(Boolean openSignup) {
            this.openSignup = openSignup;
            return this;
        }

        public Builder doHoldThirdPlaceMatch(Boolean holdThirdPlaceMatch) {
            this.holdThirdPlaceMatch = holdThirdPlaceMatch;
            return this;
        }

        public Builder withPointsForMatchWin(Double pointsForMatchWin) {
            this.pointsForMatchWin = pointsForMatchWin;
            return this;
        }

        public Builder withPointsForMatchTie(Double pointsForMatchTie) {
            this.pointsForMatchTie = pointsForMatchTie;
            return this;
        }

        public Builder withPointsForGameWin(Double pointsForGameWin) {
            this.pointsForGameWin = pointsForGameWin;
            return this;
        }

        public Builder withPointsForGameTie(Double pointsForGameTie) {
            this.pointsForGameTie = pointsForGameTie;
            return this;
        }

        public Builder withPointsForBye(Double pointsForBye) {
            this.pointsForBye = pointsForBye;
            return this;
        }

        public Builder withSwissRounds(Integer swissRounds) {
            this.swissRounds = swissRounds;
            return this;
        }

        public Builder withRankedBy(String rankedBy) {
            this.rankedBy = rankedBy;
            return this;
        }

        public Builder withRrPointsForMatchWin(Double rrPointsForMatchWin) {
            this.rrPointsForMatchWin = rrPointsForMatchWin;
            return this;
        }

        public Builder withRrPointsForMatchTie(Double rrPointsForMatchTie) {
            this.rrPointsForMatchTie = rrPointsForMatchTie;
            return this;
        }

        public Builder withRrPointsForGameWin(Double rrPointsForGameWin) {
            this.rrPointsForGameWin = rrPointsForGameWin;
            return this;
        }

        public Builder withRrPointsForGameTie(Double rrPointsForGameTie) {
            this.rrPointsForGameTie = rrPointsForGameTie;
            return this;
        }

        public Builder doAcceptAttachments(Boolean acceptAttachments) {
            this.acceptAttachments = acceptAttachments;
            return this;
        }

        public Builder doHideForum(Boolean hideForum) {
            this.hideForum = hideForum;
            return this;
        }

        public Builder doShowRounds(Boolean showRounds) {
            this.showRounds = showRounds;
            return this;
        }

        public Builder doPrivate(Boolean privat) {
            this.privat = privat;
            return this;
        }

        public Builder doNotifyUsersWhenMatchesOpen(Boolean notifyUsersWhenMatchesOpen) {
            this.notifyUsersWhenMatchesOpen = notifyUsersWhenMatchesOpen;
            return this;
        }

        public Builder doNotifyUsersWhenTheTournamentEnds(Boolean notifyUsersWhenTheTournamentEnds) {
            this.notifyUsersWhenTheTournamentEnds = notifyUsersWhenTheTournamentEnds;
            return this;
        }

        public Builder doSequentialPairings(Boolean sequentialPairings) {
            this.sequentialPairings = sequentialPairings;
            return this;
        }

        public UpdateTournamentRequest build() {
            return new UpdateTournamentRequest(originalUrlPath, name, type, urlPath, subdomain, description, openSignup,
                    holdThirdPlaceMatch, pointsForMatchWin, pointsForMatchTie, pointsForGameWin, pointsForGameTie,
                    pointsForBye, swissRounds, rankedBy, rrPointsForMatchWin, rrPointsForMatchTie,
                    rrPointsForGameWin, rrPointsForGameTie, acceptAttachments, hideForum, showRounds, privat,
                    notifyUsersWhenMatchesOpen, notifyUsersWhenTheTournamentEnds, sequentialPairings);
        }
    }
}
