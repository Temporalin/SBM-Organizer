package model.model.parser;

import model.model.*;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nicholas Hauschild
 *         Date: 5/12/13
 *         Time: 11:04 PM
 */
public class TournamentParser extends Parser<Tournament> {
    private final ListParser<Participant> partipantsParser;
    private final ListParser<Match> matchesParser;

    public TournamentParser(final ListParser<Participant> partipantsParser, final ListParser<Match> matchesParser) {
        this.partipantsParser = partipantsParser;
        this.matchesParser = matchesParser;
    }

    protected Tournament parse(final XMLStreamReader xmlReader) {
        Tournament.Builder builder = new Tournament.Builder();
        try {
            while(xmlReader.hasNext()) {
                final int event = xmlReader.next();
                switch(event) {
                    case XMLStreamReader.START_ELEMENT:
                        final int attrCount = xmlReader.getAttributeCount();
                        final Map<String, String> attrs = new HashMap<>();
                        for(int i = 0; i < attrCount; ++i) {
                            final String name = xmlReader.getAttributeLocalName(i);
                            final String value = xmlReader.getAttributeValue(i);
                            attrs.put(name, value);
                        }

                        if(isNotNil(attrs)) {
                            switch(xmlReader.getLocalName()) {
                                case "accept-attachments":
                                    final boolean acceptAttachments = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doAcceptAttchments(acceptAttachments);
                                    break;
                                case "anonymous-voting":
                                    final boolean anonymousVoting = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doAnonymousVoting(anonymousVoting);
                                    break;
                                case "category":
                                    builder.withCategory(xmlReader.getElementText());
                                    break;
                                case "check-in-at":
                                    builder.withCheckInAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "completed-at":
                                    builder.withCompletedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "created-at":
                                    builder.withCreatedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "created-by-api":
                                    final boolean createdByApi = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doCreatedByApi(createdByApi);
                                    break;
                                case "credit-capped":
                                    final boolean creditCapped = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doCreditCapped(creditCapped);
                                    break;
                                case "description":
                                    builder.withDescription(xmlReader.getElementText());
                                    break;
                                case "enable-group-stage":
                                    final boolean enableGroupStage = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doEnableGroupStage(enableGroupStage);
                                    break;
                                case "game-id":
                                    final int gameId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withGameId(gameId);
                                    break;
                                case "hide-forum":
                                    final boolean hideForum = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doHideForum(hideForum);
                                    break;
                                case "hide-seeds":
                                    final boolean hideSeeds = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doHideSeeds(hideSeeds);
                                    break;
                                case "hold-third-place-match":
                                    final boolean holdThirdPlaceMatch = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doHoldThirdPlaceMatch(holdThirdPlaceMatch);
                                    break;
                                case "id":
                                    final int id = Integer.valueOf(xmlReader.getElementText());
                                    builder.withId(id);
                                    break;
                                case "max-predictions-per-user":
                                    final int maxPredictionsPerUser = Integer.valueOf(xmlReader.getElementText());
                                    builder.withMaxPredictionsPerUser(maxPredictionsPerUser);
                                    break;
                                case "name":
                                    builder.withName(xmlReader.getElementText());
                                    break;
                                case "notify-users-when-matches-open":
                                    final boolean notifyUsersWhenMatchesOpen = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doNotifyUsersWhenMatchesOpen(notifyUsersWhenMatchesOpen);
                                    break;
                                case "notify-users-when-the-tournament-ends":
                                    final boolean notifyUsersWhenTheTournamentEnds = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doNotifyUsersWhenTheTournamentEnds(notifyUsersWhenTheTournamentEnds);
                                    break;
                                case "open-signup":
                                    final boolean openSignup = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doOpenSignup(openSignup);
                                    break;
                                case "participant-count-to-advance-per-group":
                                    final int participantCountToAdvancePerGroup = Integer.valueOf(xmlReader.getElementText());
                                    builder.withParticipantCountToAdvancePerGroup(participantCountToAdvancePerGroup);
                                    break;
                                case "participants-count":
                                    final int participantsCount = Integer.valueOf(xmlReader.getElementText());
                                    builder.withParticipantsCount(participantsCount);
                                    break;
                                case "prediction-method":
                                    final int predictionMethod = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPredictionMethod(predictionMethod);
                                    break;
                                case "predictions-opened-at":
                                    builder.withPredictionsOpenedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "private":
                                    final boolean privat = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doPrivate(privat);
                                    break;
                                case "progress-meter":
                                    final int progressMeter = Integer.valueOf(xmlReader.getElementText());
                                    builder.withProgressMeter(progressMeter);
                                    break;
                                case "pts-for-bye":
                                    final double pointsForBye = Double.valueOf(xmlReader.getElementText());
                                    builder.withPointsForBye(pointsForBye);
                                    break;
                                case "pts-for-game-tie":
                                    final double pointsForGameTie = Double.valueOf(xmlReader.getElementText());
                                    builder.withPointsForGameTie(pointsForGameTie);
                                    break;
                                case "pts-for-game-win":
                                    final double pointsForGameWin = Double.valueOf(xmlReader.getElementText());
                                    builder.withPointsForGameWin(pointsForGameWin);
                                    break;
                                case "pts-for-match-tie":
                                    final double pointsForMatchTie = Double.valueOf(xmlReader.getElementText());
                                    builder.withPointsForMatchTie(pointsForMatchTie);
                                    break;
                                case "pts-for-match-win":
                                    final double pointsForMatchWin = Double.valueOf(xmlReader.getElementText());
                                    builder.withPointsForMatchWin(pointsForMatchWin);
                                    break;
                                case "ranked-by":
                                    builder.withRankedBy(xmlReader.getElementText());
                                    break;
                                case "require-score-agreement":
                                    final boolean requireScoreAgreement = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doRequireScoreAgreement(requireScoreAgreement);
                                    break;
                                case "round-labels":
                                    builder.withRoundLabels(xmlReader.getElementText());
                                    break;
                                case "rr-pts-for-game-tie":
                                    final double rrPointsForGameTie = Double.valueOf(xmlReader.getElementText());
                                    builder.withRrPointsForGameTie(rrPointsForGameTie);
                                    break;
                                case "rr-pts-for-game-win":
                                    final double rrPointsForGameWin = Double.valueOf(xmlReader.getElementText());
                                    builder.withRrPointsForGameWin(rrPointsForGameWin);
                                    break;
                                case "rr-pts-for-match-tie":
                                    final double rrPointsForMatchTie = Double.valueOf(xmlReader.getElementText());
                                    builder.withRrPointsForMatchTie(rrPointsForMatchTie);
                                    break;
                                case "rr-pts-for-match-win":
                                    final double rrPointsForMatchWin = Double.valueOf(xmlReader.getElementText());
                                    builder.withRrPointsForMatchWin(rrPointsForMatchWin);
                                    break;
                                case "second-place-id":
                                    final int secondPlaceId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withSecondPlaceId(secondPlaceId);
                                    break;
                                case "sequential-pairings":
                                    final boolean sequentialPairings = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doSequentialPairings(sequentialPairings);
                                    break;
                                case "show-rounds":
                                    final boolean showRounds = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doShowRounds(showRounds);
                                    break;
                                case "signup-cap":
                                    final int signupCap = Integer.valueOf(xmlReader.getElementText());
                                    builder.withSignupCap(signupCap);
                                    break;
                                case "signup-requires-account":
                                    final boolean signupRequiresAccount = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doSignupRequiresAccount(signupRequiresAccount);
                                    break;
                                case "started-at":
                                    builder.withStartedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "state":
                                    final String state = xmlReader.getElementText().replace(' ', '_').toUpperCase();
                                    builder.withState(TournamentState.valueOf(state));
                                    break;
                                case "swiss-rounds":
                                    final int swissRounds = Integer.valueOf(xmlReader.getElementText());
                                    builder.withSwissRounds(swissRounds);
                                    break;
                                case "third-place-id":
                                    final int thirdPlaceId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withThirdPlaceId(thirdPlaceId);
                                    break;
                                case "tournament-type":
                                    final String type = xmlReader.getElementText().replace(' ', '_').toUpperCase();
                                    builder.withTournamentType(TournamentType.valueOf(type));
                                    break;
                                case "updated-at":
                                    builder.withUpdatedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "url":
                                    builder.withUrl(xmlReader.getElementText());
                                    break;
                                case "winner-id":
                                    final int winnerId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withWinnerId(winnerId);
                                    break;
                                case "description-source":
                                    builder.withDescriptionSource(xmlReader.getElementText());
                                    break;
                                case "subdomain":
                                    builder.withSubdomain(xmlReader.getElementText());
                                    break;
                                case "full-challonge-url":
                                    builder.withFullChallongeUrl(xmlReader.getElementText());
                                    break;
                                case "live-image-url":
                                    builder.withLiveImageUrl(xmlReader.getElementText());
                                    break;
                                case "sign-up-url":
                                    builder.withSignUpUrl(xmlReader.getElementText());
                                    break;
                                case "review-before-finalizing":
                                    final boolean reviewBeforeFinalizing = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doReviewBeforeFinalizing(reviewBeforeFinalizing);
                                    break;
                                case "participants":
                                    final List<Participant> participants = partipantsParser.parse(xmlReader);
                                    builder.withParticipants(participants);
                                    break;
                                case "matches":
                                    final List<Match> matches = matchesParser.parse(xmlReader);
                                    builder.withMatches(matches);
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        switch(xmlReader.getLocalName()) {
                            case "tournament":
                                return builder.build();
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch(XMLStreamException | ParseException e) {
            throw new RuntimeException(e);
        }
        throw new IllegalArgumentException("Couldn't parse Tournament from xml");
    }
}
