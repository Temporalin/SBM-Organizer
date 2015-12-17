package challonge.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/11/13
 *         Time: 11:30 PM
 */
public class Tournament {
    private final boolean acceptAttachments;
    private final boolean anonymousVoting;
    private final String category;
    private final Date checkInAt;
    private final Date completedAt;
    private final Date createdAt;
    private final boolean createdByApi;
    private final boolean creditCapped;
    private final String description;
    private final boolean enableGroupStage;
    private final int gameId;
    private final boolean hideForum;
    private final boolean hideSeeds;
    private final boolean holdThirdPlaceMatch;
    private final int id;
    private final int maxPredictionsPerUser;
    private final String name;
    private final boolean notifyUsersWhenMatchesOpen;
    private final boolean notifyUsersWhenTheTournamentEnds;
    private final boolean openSignup;
    private final int participantCountToAdvancePerGroup;
    private final int participantsCount;
    private final int predictionMethod;
    private final Date predictionsOpenedAt;
    private final boolean privat;
    private final int progressMeter;
    private final double pointsForBye;
    private final double pointsForGameTie;
    private final double pointsForGameWin;
    private final double pointsForMatchTie;
    private final double pointsForMatchWin;
    private final String rankedBy;
    private final boolean requireScoreAgreement;
    private final String roundLabels;
    private final double rrPointsForGameTie;
    private final double rrPointsForGameWin;
    private final double rrPointsForMatchTie;
    private final double rrPointsForMatchWin;
    private final int secondPlaceId;
    private final boolean sequentialPairings;
    private final boolean showRounds;
    private final int signupCap;
    private final boolean signupRequiresAccount;
    private final Date startedAt;
    private final TournamentState state;
    private final int swissRounds;
    private final int thirdPlaceId;
    private final TournamentType tournamentType;
    private final Date updatedAt;
    private final String url;
    private final int winnerId;
    private final String descriptionSource;
    private final String subdomain;
    private final String fullChallongeUrl;
    private final String liveImageUrl;
    private final String signUpUrl;
    private final boolean reviewBeforeFinalizing;
    private final List<Participant> participants;
    private final List<Match> matches;

    public Tournament(final boolean acceptAttachments, final boolean anonymousVoting, final String category,
                      final Date checkInAt, final Date completedAt, final Date createdAt, final boolean createdByApi,
                      final boolean creditCapped, final String description, final boolean enableGroupStage,
                      final int gameId, final boolean hideForum, final boolean hideSeeds, final boolean holdThirdPlaceMatch,
                      final int id, final int maxPredictionsPerUser, final String name, final boolean notifyUsersWhenMatchesOpen,
                      final boolean notifyUsersWhenTheTournamentEnds, final boolean openSignup,
                      final int participantCountToAdvancePerGroup, final int participantsCount, final int predictionMethod,
                      final Date predictionsOpenedAt, final boolean privat, final int progressMeter, final double pointsForBye,
                      final double pointsForGameTie, final double pointsForGameWin, final double pointsForMatchTie,
                      final double pointsForMatchWin, final String rankedBy, final boolean requireScoreAgreement,
                      final String roundLabels, final double rrPointsForGameTie, final double rrPointsForGameWin,
                      final double rrPointsForMatchTie, final double rrPointsForMatchWin, final int secondPlaceId,
                      final boolean sequentialPairings, final boolean showRounds, final int signupCap,
                      final boolean signupRequiresAccount, final Date startedAt, final TournamentState state,
                      final int swissRounds, final int thirdPlaceId, final TournamentType tournamentType, final Date updatedAt,
                      final String url, final int winnerId, final String descriptionSource, final String subdomain,
                      final String fullChallongeUrl, final String liveImageUrl, final String signUpUrl,
                      final boolean reviewBeforeFinalizing, final List<Participant> participants, final List<Match> matches) {
        this.acceptAttachments = acceptAttachments;
        this.anonymousVoting = anonymousVoting;
        this.category = category;
        this.checkInAt = checkInAt;
        this.completedAt = completedAt;
        this.createdAt = createdAt;
        this.createdByApi = createdByApi;
        this.creditCapped = creditCapped;
        this.description = description;
        this.enableGroupStage = enableGroupStage;
        this.gameId = gameId;
        this.hideForum = hideForum;
        this.hideSeeds = hideSeeds;
        this.holdThirdPlaceMatch = holdThirdPlaceMatch;
        this.id = id;
        this.maxPredictionsPerUser = maxPredictionsPerUser;
        this.name = name;
        this.notifyUsersWhenMatchesOpen = notifyUsersWhenMatchesOpen;
        this.notifyUsersWhenTheTournamentEnds = notifyUsersWhenTheTournamentEnds;
        this.openSignup = openSignup;
        this.participantCountToAdvancePerGroup = participantCountToAdvancePerGroup;
        this.participantsCount = participantsCount;
        this.predictionMethod = predictionMethod;
        this.predictionsOpenedAt = predictionsOpenedAt;
        this.privat = privat;
        this.progressMeter = progressMeter;
        this.pointsForBye = pointsForBye;
        this.pointsForGameTie = pointsForGameTie;
        this.pointsForGameWin = pointsForGameWin;
        this.pointsForMatchTie = pointsForMatchTie;
        this.pointsForMatchWin = pointsForMatchWin;
        this.rankedBy = rankedBy;
        this.requireScoreAgreement = requireScoreAgreement;
        this.roundLabels = roundLabels;
        this.rrPointsForGameTie = rrPointsForGameTie;
        this.rrPointsForGameWin = rrPointsForGameWin;
        this.rrPointsForMatchTie = rrPointsForMatchTie;
        this.rrPointsForMatchWin = rrPointsForMatchWin;
        this.secondPlaceId = secondPlaceId;
        this.sequentialPairings = sequentialPairings;
        this.showRounds = showRounds;
        this.signupCap = signupCap;
        this.signupRequiresAccount = signupRequiresAccount;
        this.startedAt = startedAt;
        this.state = state;
        this.swissRounds = swissRounds;
        this.thirdPlaceId = thirdPlaceId;
        this.tournamentType = tournamentType;
        this.updatedAt = updatedAt;
        this.url = url;
        this.winnerId = winnerId;
        this.descriptionSource = descriptionSource;
        this.subdomain = subdomain;
        this.fullChallongeUrl = fullChallongeUrl;
        this.liveImageUrl = liveImageUrl;
        this.signUpUrl = signUpUrl;
        this.reviewBeforeFinalizing = reviewBeforeFinalizing;
        this.participants = participants;
        this.matches = matches;
    }

    public boolean isAcceptAttachments() {
        return acceptAttachments;
    }

    public boolean isAnonymousVoting() {
        return anonymousVoting;
    }

    public String getCategory() {
        return category;
    }

    public Date getCheckInAt() {
        return checkInAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isCreatedByApi() {
        return createdByApi;
    }

    public boolean isCreditCapped() {
        return creditCapped;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnableGroupStage() {
        return enableGroupStage;
    }

    public int getGameId() {
        return gameId;
    }

    public boolean isHideForum() {
        return hideForum;
    }

    public boolean isHideSeeds() {
        return hideSeeds;
    }

    public boolean isHoldThirdPlaceMatch() {
        return holdThirdPlaceMatch;
    }

    public int getId() {
        return id;
    }

    public int getMaxPredictionsPerUser() {
        return maxPredictionsPerUser;
    }

    public String getName() {
        return name;
    }

    public boolean isNotifyUsersWhenMatchesOpen() {
        return notifyUsersWhenMatchesOpen;
    }

    public boolean isNotifyUsersWhenTheTournamentEnds() {
        return notifyUsersWhenTheTournamentEnds;
    }

    public boolean isOpenSignup() {
        return openSignup;
    }

    public int getParticipantCountToAdvancePerGroup() {
        return participantCountToAdvancePerGroup;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public int getPredictionMethod() {
        return predictionMethod;
    }

    public Date getPredictionsOpenedAt() {
        return predictionsOpenedAt;
    }

    public boolean isPrivat() {
        return privat;
    }

    public int getProgressMeter() {
        return progressMeter;
    }

    public double getPointsForBye() {
        return pointsForBye;
    }

    public double getPointsForGameTie() {
        return pointsForGameTie;
    }

    public double getPointsForGameWin() {
        return pointsForGameWin;
    }

    public double getPointsForMatchTie() {
        return pointsForMatchTie;
    }

    public double getPointsForMatchWin() {
        return pointsForMatchWin;
    }

    public String getRankedBy() {
        return rankedBy;
    }

    public boolean isRequireScoreAgreement() {
        return requireScoreAgreement;
    }

    public String getRoundLabels() {
        return roundLabels;
    }

    public double getRrPointsForGameTie() {
        return rrPointsForGameTie;
    }

    public double getRrPointsForGameWin() {
        return rrPointsForGameWin;
    }

    public double getRrPointsForMatchTie() {
        return rrPointsForMatchTie;
    }

    public double getRrPointsForMatchWin() {
        return rrPointsForMatchWin;
    }

    public int getSecondPlaceId() {
        return secondPlaceId;
    }

    public boolean isSequentialPairings() {
        return sequentialPairings;
    }

    public boolean isShowRounds() {
        return showRounds;
    }

    public int getSignupCap() {
        return signupCap;
    }

    public boolean isSignupRequiresAccount() {
        return signupRequiresAccount;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public TournamentState getState() {
        return state;
    }

    public int getSwissRounds() {
        return swissRounds;
    }

    public int getThirdPlaceId() {
        return thirdPlaceId;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public String getDescriptionSource() {
        return descriptionSource;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getFullChallongeUrl() {
        return fullChallongeUrl;
    }

    public String getLiveImageUrl() {
        return liveImageUrl;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public boolean isReviewBeforeFinalizing() {
        return reviewBeforeFinalizing;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public static class Builder {
        private boolean acceptAttachments;
        private boolean anonymousVoting;
        private String category;
        private Date checkInAt;
        private Date completedAt;
        private Date createdAt;
        private boolean createdByApi;
        private boolean creditCapped;
        private String description;
        private boolean enableGroupStage;
        private int gameId;
        private boolean hideForum;
        private boolean hideSeeds;
        private boolean holdThirdPlaceMatch;
        private int id;
        private int maxPredictionsPerUser;
        private String name;
        private boolean notifyUsersWhenMatchesOpen;
        private boolean notifyUsersWhenTheTournamentEnds;
        private boolean openSignup;
        private int participantCountToAdvancePerGroup;
        private int participantsCount;
        private int predictionMethod;
        private Date predictionsOpenedAt;
        private boolean privat;
        private int progressMeter;
        private double pointsForBye;
        private double pointsForGameTie;
        private double pointsForGameWin;
        private double pointsForMatchTie;
        private double pointsForMatchWin;
        private String rankedBy;
        private boolean requireScoreAgreement;
        private String roundLabels;
        private double rrPointsForGameTie;
        private double rrPointsForGameWin;
        private double rrPointsForMatchTie;
        private double rrPointsForMatchWin;
        private int secondPlaceId;
        private boolean sequentialPairings;
        private boolean showRounds;
        private int signupCap;
        private boolean signupRequiresAccount;
        private Date startedAt;
        private TournamentState state;
        private int swissRounds;
        private int thirdPlaceId;
        private TournamentType tournamentType;
        private Date updatedAt;
        private String url;
        private int winnerId;
        private String descriptionSource;
        private String subdomain;
        private String fullChallongeUrl;
        private String liveImageUrl;
        private String signUpUrl;
        private boolean reviewBeforeFinalizing;
        private List<Participant> participants = new ArrayList<>();
        private List<Match> matches = new ArrayList<>();

        public Builder doAcceptAttchments(final boolean acceptAttachments) {
            this.acceptAttachments = acceptAttachments;
            return this;
        }

        public Builder doAnonymousVoting(final boolean anonymousVoting) {
            this.anonymousVoting = anonymousVoting;
            return this;
        }

        public Builder withCategory(final String category) {
            this.category = category;
            return this;
        }

        public Builder withCheckInAt(final Date checkInAt) {
            this.checkInAt = checkInAt;
            return this;
        }

        public Builder withCompletedAt(final Date completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        public Builder withCreatedAt(final Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder doCreatedByApi(final boolean createdByApi) {
            this.createdByApi = createdByApi;
            return this;
        }

        public Builder doCreditCapped(final boolean creditCapped) {
            this.creditCapped = creditCapped;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder doEnableGroupStage(final boolean enableGroupStage) {
            this.enableGroupStage = enableGroupStage;
            return this;
        }

        public Builder withGameId(final int gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder doHideForum(final boolean hideForum) {
            this.hideForum = hideForum;
            return this;
        }

        public Builder doHideSeeds(final boolean hideSeeds) {
            this.hideSeeds = hideSeeds;
            return this;
        }

        public Builder doHoldThirdPlaceMatch(final boolean holdThirdPlaceMatch) {
            this.holdThirdPlaceMatch = holdThirdPlaceMatch;
            return this;
        }

        public Builder withId(final int id) {
            this.id = id;
            return this;
        }

        public Builder withMaxPredictionsPerUser(final int maxPredictionsPerUser) {
            this.maxPredictionsPerUser = maxPredictionsPerUser;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder doNotifyUsersWhenMatchesOpen(final boolean notifyUsersWhenMatchesOpen) {
            this.notifyUsersWhenMatchesOpen = notifyUsersWhenMatchesOpen;
            return this;
        }

        public Builder doNotifyUsersWhenTheTournamentEnds(final boolean notifyUsersWhenTheTournamentEnds) {
            this.notifyUsersWhenTheTournamentEnds = notifyUsersWhenTheTournamentEnds;
            return this;
        }

        public Builder doOpenSignup(final boolean openSignup) {
            this.openSignup = openSignup;
            return this;
        }

        public Builder withParticipantCountToAdvancePerGroup(final int participantCountToAdvancePerGroup) {
            this.participantCountToAdvancePerGroup = participantCountToAdvancePerGroup;
            return this;
        }

        public Builder withParticipantsCount(final int participantsCount) {
            this.participantsCount = participantsCount;
            return this;
        }

        public Builder withPredictionMethod(final int predictionMethod) {
            this.predictionMethod = predictionMethod;
            return this;
        }

        public Builder withPredictionsOpenedAt(final Date predictionsOpenedAt) {
            this.predictionsOpenedAt = predictionsOpenedAt;
            return this;
        }

        public Builder doPrivate(final boolean privat) {
            this.privat = privat;
            return this;
        }

        public Builder withProgressMeter(final int progressMeter) {
            this.progressMeter = progressMeter;
            return this;
        }

        public Builder withPointsForBye(final double pointsForBye) {
            this.pointsForBye = pointsForBye;
            return this;
        }

        public Builder withPointsForGameTie(final double pointsForGameTie) {
            this.pointsForGameTie = pointsForGameTie;
            return this;
        }

        public Builder withPointsForGameWin(final double pointsForGameWin) {
            this.pointsForGameWin = pointsForGameWin;
            return this;
        }

        public Builder withPointsForMatchTie(final double pointsForMatchTie) {
            this.pointsForMatchTie = pointsForMatchTie;
            return this;
        }

        public Builder withPointsForMatchWin(final double pointsForMatchWin) {
            this.pointsForMatchWin = pointsForMatchWin;
            return this;
        }

        public Builder withRankedBy(final String rankedBy) {
            this.rankedBy = rankedBy;
            return this;
        }

        public Builder doRequireScoreAgreement(final boolean requireScoreAgreement) {
            this.requireScoreAgreement = requireScoreAgreement;
            return this;
        }

        public Builder withRoundLabels(final String roundLabels) {
            this.roundLabels = roundLabels;
            return this;
        }

        public Builder withRrPointsForGameTie(final double rrPointsForGameTie) {
            this.rrPointsForGameTie = rrPointsForGameTie;
            return this;
        }

        public Builder withRrPointsForGameWin(final double rrPointsForGameWin) {
            this.rrPointsForGameWin = rrPointsForGameWin;
            return this;
        }

        public Builder withRrPointsForMatchTie(final double rrPointsForMatchTie) {
            this.rrPointsForMatchTie = rrPointsForMatchTie;
            return this;
        }

        public Builder withRrPointsForMatchWin(final double rrPointsForMatchWin) {
            this.rrPointsForMatchWin = rrPointsForMatchWin;
            return this;
        }

        public Builder withSecondPlaceId(final int secondPlaceId) {
            this.secondPlaceId = secondPlaceId;
            return this;
        }

        public Builder doSequentialPairings(final boolean sequentialPairings) {
            this.sequentialPairings = sequentialPairings;
            return this;
        }

        public Builder doShowRounds(final boolean showRounds) {
            this.showRounds = showRounds;
            return this;
        }

        public Builder withSignupCap(final int signupCap) {
            this.signupCap = signupCap;
            return this;
        }

        public Builder doSignupRequiresAccount(final boolean signupRequiresAccount) {
            this.signupRequiresAccount = signupRequiresAccount;
            return this;
        }

        public Builder withStartedAt(final Date startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        public Builder withState(final TournamentState state) {
            this.state = state;
            return this;
        }

        public Builder withSwissRounds(final int swissRounds) {
            this.swissRounds = swissRounds;
            return this;
        }

        public Builder withThirdPlaceId(final int thirdPlaceId) {
            this.thirdPlaceId = thirdPlaceId;
            return this;
        }

        public Builder withTournamentType(final TournamentType tournamentType) {
            this.tournamentType = tournamentType;
            return this;
        }

        public Builder withUpdatedAt(final Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Builder withWinnerId(final int winnerId) {
            this.winnerId = winnerId;
            return this;
        }

        public Builder withDescriptionSource(final String descriptionSource) {
            this.descriptionSource = descriptionSource;
            return this;
        }

        public Builder withSubdomain(final String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        public Builder withFullChallongeUrl(final String fullChallongeUrl) {
            this.fullChallongeUrl = fullChallongeUrl;
            return this;
        }

        public Builder withLiveImageUrl(final String liveImageUrl) {
            this.liveImageUrl = liveImageUrl;
            return this;
        }

        public Builder withSignUpUrl(final String signUpUrl) {
            this.signUpUrl = signUpUrl;
            return this;
        }

        public Builder doReviewBeforeFinalizing(final boolean reviewBeforeFinalizing) {
            this.reviewBeforeFinalizing = reviewBeforeFinalizing;
            return this;
        }

        public Builder withParticipants(final List<Participant> participants) {
            this.participants = participants;
            return this;
        }

        public Builder withMatches(final List<Match> matches) {
            this.matches = matches;
            return this;
        }

        public Tournament build() {
            return new Tournament(acceptAttachments, anonymousVoting, category, checkInAt, completedAt,
                    createdAt, createdByApi, creditCapped, description, enableGroupStage, gameId,
                    hideForum, hideSeeds, holdThirdPlaceMatch, id, maxPredictionsPerUser, name,
                    notifyUsersWhenMatchesOpen, notifyUsersWhenTheTournamentEnds, openSignup,
                    participantCountToAdvancePerGroup, participantsCount, predictionMethod,
                    predictionsOpenedAt, privat, progressMeter, pointsForBye, pointsForGameTie,
                    pointsForGameWin, pointsForMatchTie, pointsForMatchWin, rankedBy, requireScoreAgreement,
                    roundLabels, rrPointsForGameTie, rrPointsForGameWin, rrPointsForMatchTie,
                    rrPointsForMatchWin, secondPlaceId, sequentialPairings, showRounds, signupCap,
                    signupRequiresAccount, startedAt, state, swissRounds, thirdPlaceId, tournamentType,
                    updatedAt, url, winnerId, descriptionSource, subdomain, fullChallongeUrl, liveImageUrl,
                    signUpUrl, reviewBeforeFinalizing, participants, matches);
        }
    }
}
