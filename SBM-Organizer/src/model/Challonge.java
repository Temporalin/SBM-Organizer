package model;

import model.http.HttpInvoker;
import model.http.HttpMethod;
import model.http.HttpRequest;
import model.http.HttpResponse;
import model.model.*;
import model.model.parser.*;
import model.request.*;

import java.util.Date;
import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/11/13
 *         Time: 11:22 PM
 */
public class Challonge {
    private static final String BASE_URL = "https://challonge.com/api/";

    private final HttpInvoker httpInvoker;
    private final TournamentParser tournamentParser;
    private final ListParser<Tournament> tournamentsParser;
    private final ParticipantParser participantParser;
    private final ListParser<Participant> participantsParser;
    private final MatchParser matchParser;
    private final ListParser<Match> matchesParser;

    public Challonge(final String apiKey) {
        this.httpInvoker = new HttpInvoker(apiKey);
        this.matchParser = new MatchParser();
        this.matchesParser = new ListParser<>(matchParser, "match");
        this.participantParser = new ParticipantParser(matchesParser);
        this.participantsParser = new ListParser<>(participantParser, "participant");
        this.tournamentParser = new TournamentParser(participantsParser, matchesParser);
        this.tournamentsParser = new ListParser<>(tournamentParser, "tournament");
    }

    public List<Tournament> listTournaments() {
        return listTournaments(new ListTournamentRequest.Builder().build());
    }

    public List<Tournament> listTournaments(final ListTournamentRequest request) {
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments.xml");

        final TournamentState state = request.getState();
        if(state != null) {
            requestBuilder.withQueryParam("state", state.getQueryParamValue());
        }

        final TournamentType type = request.getType();
        if(type != null) {
            requestBuilder.withQueryParam("type", type.getQueryParamValue());
        }

        final Date createdBefore = request.getCreatedBefore();
        if(createdBefore != null) {
            requestBuilder.withQueryParam("created_before", DateFormats.REQUEST_SDF.get().format(createdBefore));
        }

        final Date createdAfter = request.getCreatedAfter();
        if(createdAfter != null) {
            requestBuilder.withQueryParam("created_after", DateFormats.REQUEST_SDF.get().format(createdAfter));
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentsParser.parse(httpResponse.getBody());
    }

    public Tournament createTournament(final String name, final TournamentType type, final String urlPath) {
        return createTournament(new CreateTournamentRequest.Builder(name, type, urlPath).build());
    }

    public Tournament createTournament(final CreateTournamentRequest request) {
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments.xml");
        requestBuilder.withMethod(HttpMethod.POST);

        requestBuilder.withBodyParam("tournament[name]", request.getName());
        requestBuilder.withBodyParam("tournament[tournament_type]", request.getType().getBodyValue());
        requestBuilder.withBodyParam("tournament[url]", request.getUrlPath());

        final String subdomain = request.getSubdomain();
        if(subdomain != null) {
            requestBuilder.withBodyParam("tournament[subdomain]", subdomain);
        }

        final String description = request.getDescription();
        if(description != null) {
            requestBuilder.withBodyParam("tournament[description]", description);
        }

        final Boolean openSignup = request.isOpenSignup();
        if(openSignup != null) {
            requestBuilder.withBodyParam("tournament[open_signup]", openSignup.toString());
        }

        final Boolean holdThirdPlaceMatch = request.isHoldThirdPlaceMatch();
        if(holdThirdPlaceMatch != null) {
            requestBuilder.withBodyParam("tournament[hold_third_place_match]", holdThirdPlaceMatch.toString());
        }

        final Double pointsForMatchWin = request.getPointsForMatchWin();
        if(pointsForMatchWin != null) {
            requestBuilder.withBodyParam("tournament[pts_for_match_win]", pointsForMatchWin.toString());
        }

        final Double pointsForMatchTie = request.getPointsForMatchTie();
        if(pointsForMatchTie != null) {
            requestBuilder.withBodyParam("tournament[pts_for_match_tie]", pointsForMatchTie.toString());
        }

        final Double pointsForGameWin = request.getPointsForGameWin();
        if(pointsForGameWin != null) {
            requestBuilder.withBodyParam("tournament[pts_for_game_win]", pointsForGameWin.toString());
        }

        final Double pointsForGameTie = request.getPointsForGameTie();
        if(pointsForGameTie != null) {
            requestBuilder.withBodyParam("tournament[pts_for_game_tie]", pointsForGameTie.toString());
        }

        final Double pointsForBye = request.getPointsForBye();
        if(pointsForBye != null) {
            requestBuilder.withBodyParam("tournament[pts_for_bye]", pointsForBye.toString());
        }

        final Integer swissRounds = request.getSwissRounds();
        if(swissRounds != null) {
            requestBuilder.withBodyParam("tournament[swiss_rounds]", swissRounds.toString());
        }

        final String rankedBy = request.getRankedBy();
        if(rankedBy != null) {
            requestBuilder.withBodyParam("tournament[ranked_by]", rankedBy);
        }

        final Double rrPointsForMatchWin = request.getRrPointsForMatchWin();
        if(rrPointsForMatchWin != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_match_win]", rrPointsForMatchWin.toString());
        }

        final Double rrPointsForMatchTie = request.getRrPointsForMatchTie();
        if(rrPointsForMatchTie != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_match_tie]", rrPointsForMatchTie.toString());
        }

        final Double rrPointsForGameWin = request.getRrPointsForGameWin();
        if(rrPointsForGameWin != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_game_win]", rrPointsForGameWin.toString());
        }

        final Double rrPointsForGameTie = request.getRrPointsForGameTie();
        if(rrPointsForGameTie != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_game_tie]", rrPointsForGameTie.toString());
        }

        final Boolean acceptAttachments = request.isAcceptAttachments();
        if(acceptAttachments != null) {
            requestBuilder.withBodyParam("tournament[accept_attachments]", acceptAttachments.toString());
        }

        final Boolean hideForum = request.isHideForum();
        if(hideForum != null) {
            requestBuilder.withBodyParam("tournament[hide_forum]", hideForum.toString());
        }

        final Boolean showRounds = request.isShowRounds();
        if(showRounds != null) {
            requestBuilder.withBodyParam("tournament[show_rounds]", showRounds.toString());
        }

        final Boolean privat = request.isPrivate();
        if(privat != null) {
            requestBuilder.withBodyParam("tournament[private]", privat.toString());
        }

        final Boolean notifyUsersWhenMatchesOpen = request.isNotifyUsersWhenMatchesOpen();
        if(notifyUsersWhenMatchesOpen != null) {
            requestBuilder.withBodyParam("tournament[notify_users_when_matches_open]",
                    notifyUsersWhenMatchesOpen.toString());
        }

        final Boolean notifyUsersWhenTheTournamentEnds = request.isNotifyUsersWhenTheTournamentEnds();
        if(notifyUsersWhenTheTournamentEnds != null) {
            requestBuilder.withBodyParam("tournament[notify_users_when_the_tournament_ends]",
                    notifyUsersWhenTheTournamentEnds.toString());
        }

        final Boolean sequentialPairings = request.isSequentialPairings();
        if(sequentialPairings != null) {
            requestBuilder.withBodyParam("tournament[sequential_pairings]", sequentialPairings.toString());
        }

        final Integer signupCap = request.getSignupCap();
        if(signupCap != null) {
            requestBuilder.withBodyParam("tournament[signup_cap]", signupCap.toString());
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentParser.parse(httpResponse.getBody());
    }

    public Tournament getTournament(final String urlPath) {
        final GetTournamentRequest request = new GetTournamentRequest.Builder(urlPath).build();
        return getTournament(request);
    }

    public Tournament getTournament(final GetTournamentRequest request) {
        final String urlPath = request.getUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
                + urlPath + ".xml");

        final Boolean includeParticipants = request.isIncludeParticipants();
        if(includeParticipants != null) {
            final String paramValue = includeParticipants ? "1" : "0";
            requestBuilder.withQueryParam("include_participants", paramValue);
        }

        final Boolean includeMatches = request.isIncludeMatches();
        if(includeMatches != null) {
            final String paramValue = includeMatches ? "1" : "0";
            requestBuilder.withQueryParam("include_matches", paramValue);
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentParser.parse(httpResponse.getBody());
    }

    public Tournament updateTournament(final UpdateTournamentRequest request) {
        final String urlPath = request.getOriginalUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
                + urlPath + ".xml");

        requestBuilder.withMethod(HttpMethod.PUT);

        final String name = request.getName();
        if(name != null) {
            requestBuilder.withBodyParam("tournament[name]", name);
        }

        final TournamentType type = request.getType();
        if(type != null) {
            requestBuilder.withBodyParam("tournament[tournament_type]", type.getBodyValue());
        }

        final String newUrlPath = request.getUrlPath();
        if(newUrlPath != null) {
            requestBuilder.withBodyParam("tournament[url]", newUrlPath);
        }

        final String subdomain = request.getSubdomain();
        if(subdomain != null) {
            requestBuilder.withBodyParam("tournament[subdomain]", subdomain);
        }

        final String description = request.getDescription();
        if(description != null) {
            requestBuilder.withBodyParam("tournament[description]", description);
        }

        final Boolean openSignup = request.isOpenSignup();
        if(openSignup != null) {
            requestBuilder.withBodyParam("tournament[open_signup]", openSignup.toString());
        }

        final Boolean holdThirdPlaceMatch = request.isHoldThirdPlaceMatch();
        if(holdThirdPlaceMatch != null) {
            requestBuilder.withBodyParam("tournament[hold_third_place_match]", holdThirdPlaceMatch.toString());
        }

        final Double pointsForMatchWin = request.getPointsForMatchWin();
        if(pointsForMatchWin != null) {
            requestBuilder.withBodyParam("tournament[pts_for_match_win]", pointsForMatchWin.toString());
        }

        final Double pointsForMatchTie = request.getPointsForMatchTie();
        if(pointsForMatchTie != null) {
            requestBuilder.withBodyParam("tournament[pts_for_match_tie]", pointsForMatchTie.toString());
        }

        final Double pointsForGameWin = request.getPointsForGameWin();
        if(pointsForGameWin != null) {
            requestBuilder.withBodyParam("tournament[pts_for_game_win]", pointsForGameWin.toString());
        }

        final Double pointsForGameTie = request.getPointsForGameTie();
        if(pointsForGameTie != null) {
            requestBuilder.withBodyParam("tournament[pts_for_game_tie]", pointsForGameTie.toString());
        }

        final Double pointsForBye = request.getPointsForBye();
        if(pointsForBye != null) {
            requestBuilder.withBodyParam("tournament[pts_for_bye]", pointsForBye.toString());
        }

        final Integer swissRounds = request.getSwissRounds();
        if(swissRounds != null) {
            requestBuilder.withBodyParam("tournament[swiss_rounds]", swissRounds.toString());
        }

        final String rankedBy = request.getRankedBy();
        if(rankedBy != null) {
            requestBuilder.withBodyParam("tournament[ranked_by]", rankedBy);
        }

        final Double rrPointsForMatchWin = request.getRrPointsForMatchWin();
        if(rrPointsForMatchWin != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_match_win]", rrPointsForMatchWin.toString());
        }

        final Double rrPointsForMatchTie = request.getRrPointsForMatchTie();
        if(rrPointsForMatchTie != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_match_tie]", rrPointsForMatchTie.toString());
        }

        final Double rrPointsForGameWin = request.getRrPointsForGameWin();
        if(rrPointsForGameWin != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_game_win]", rrPointsForGameWin.toString());
        }

        final Double rrPointsForGameTie = request.getRrPointsForGameTie();
        if(rrPointsForGameTie != null) {
            requestBuilder.withBodyParam("tournament[rr_pts_for_game_tie]", rrPointsForGameTie.toString());
        }

        final Boolean acceptAttachments = request.isAcceptAttachments();
        if(acceptAttachments != null) {
            requestBuilder.withBodyParam("tournament[accept_attachments]", acceptAttachments.toString());
        }

        final Boolean hideForum = request.isHideForum();
        if(hideForum != null) {
            requestBuilder.withBodyParam("tournament[hide_forum]", hideForum.toString());
        }

        final Boolean showRounds = request.isShowRounds();
        if(showRounds != null) {
            requestBuilder.withBodyParam("tournament[show_rounds]", showRounds.toString());
        }

        final Boolean privat = request.isPrivate();
        if(privat != null) {
            requestBuilder.withBodyParam("tournament[private]", privat.toString());
        }

        final Boolean notifyUsersWhenMatchesOpen = request.isNotifyUsersWhenMatchesOpen();
        if(notifyUsersWhenMatchesOpen != null) {
            requestBuilder.withBodyParam("tournament[notify_users_when_matches_open]",
                    notifyUsersWhenMatchesOpen.toString());
        }

        final Boolean notifyUsersWhenTheTournamentEnds = request.isNotifyUsersWhenTheTournamentEnds();
        if(notifyUsersWhenTheTournamentEnds != null) {
            requestBuilder.withBodyParam("tournament[notify_users_when_the_tournament_ends]",
                    notifyUsersWhenTheTournamentEnds.toString());
        }

        final Boolean sequentialPairings = request.isSequentialPairings();
        if(sequentialPairings != null) {
            requestBuilder.withBodyParam("tournament[sequential_pairings]", sequentialPairings.toString());
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentParser.parse(httpResponse.getBody());
    }

    public Tournament deleteTournament(final String urlPath) {
        return deleteTournament(new DeleteTournamentRequest(urlPath));
    }

    public Tournament deleteTournament(final DeleteTournamentRequest request) {
        final String urlPath = request.getUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + urlPath + ".xml");

        requestBuilder.withMethod(HttpMethod.DELETE);

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentParser.parse(httpResponse.getBody());
    }

    public Tournament startTournament(final String urlPath) {
        final StartTournamentRequest request = new StartTournamentRequest.Builder(urlPath).build();
        return startTournament(request);
    }

    public Tournament startTournament(final StartTournamentRequest request) {
        final String urlPath = request.getUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + urlPath + "/start.xml");

        requestBuilder.withMethod(HttpMethod.POST);

        final Boolean includeParticipants = request.isIncludeParticipants();
        if(includeParticipants != null) {
            final String paramValue = includeParticipants ? "1" : "0";
            requestBuilder.withQueryParam("include_participants", paramValue);
        }

        final Boolean includeMatches = request.isIncludeMatches();
        if(includeMatches != null) {
            final String paramValue = includeMatches ? "1" : "0";
            requestBuilder.withQueryParam("include_matches", paramValue);
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentParser.parse(httpResponse.getBody());
    }

    public Tournament resetTournament(final String urlPath) {
        final ResetTournamentRequest request = new ResetTournamentRequest.Builder(urlPath).build();
        return resetTournament(request);
    }

    public Tournament resetTournament(final ResetTournamentRequest request) {
        final String urlPath = request.getUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + urlPath + "/reset.xml");

        requestBuilder.withMethod(HttpMethod.POST);

        final Boolean includeParticipants = request.isIncludeParticipants();
        if(includeParticipants != null) {
            final String paramValue = includeParticipants ? "1" : "0";
            requestBuilder.withQueryParam("include_participants", paramValue);
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return tournamentParser.parse(httpResponse.getBody());
    }

    public List<Participant> listParticipants(final String tournamentUrlPath) {
        return listParticipants(new ListParticipantRequest(tournamentUrlPath));
    }

    public List<Participant> listParticipants(final ListParticipantRequest request) {
        final String urlPath = request.getTournamentUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + urlPath + "/participants.xml");

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return participantsParser.parse(httpResponse.getBody());
    }

    public Participant createParticipant(final String tournamentUrlPath, final String name) {
        final CreateParticipantRequest request = new CreateParticipantRequest.Builder(tournamentUrlPath, name).build();
        return createParticipant(request);
    }

    public Participant createParticipant(final CreateParticipantRequest request) {
        final String urlPath = request.getTournamentUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + urlPath + "/participants.xml");

        requestBuilder.withMethod(HttpMethod.POST);

        requestBuilder.withBodyParam("participant[name]", request.getName());

        final String challongeUsername = request.getChallongeUsername();
        if(challongeUsername != null) {
            requestBuilder.withBodyParam("participant[challonge_username]", challongeUsername);
        }

        final String email = request.getEmail();
        if(email != null) {
            requestBuilder.withBodyParam("participant[email]", email);
        }

        final Integer seed = request.getSeed();
        if(seed != null) {
            requestBuilder.withBodyParam("participant[seed]", seed.toString());
        }

        final String misc = request.getMisc();
        if(misc != null) {
            requestBuilder.withBodyParam("participant[misc]", misc);
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return participantParser.parse(httpResponse.getBody());
    }

    public Participant getParticipant(final String tournamentUrlPath, final int participantUrlPath) {
        final GetParticipantRequest request = new GetParticipantRequest.Builder(tournamentUrlPath, participantUrlPath)
                .build();
        return getParticipant(request);
    }

    public Participant getParticipant(final GetParticipantRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final int participantUrlPath = request.getParticipantId();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/participants/" + participantUrlPath + ".xml");

        final Boolean includeMatches = request.isIncludeMatches();
        if(includeMatches != null) {
            requestBuilder.withQueryParam("include_matches", includeMatches.toString());
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return participantParser.parse(httpResponse.getBody());
    }

    public Participant updateParticipant(final UpdateParticipantRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final int participantUrlPath = request.getParticipantId();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/participants/" + participantUrlPath + ".xml");

        requestBuilder.withMethod(HttpMethod.PUT);

        final String name = request.getName();
        if(name != null) {
            requestBuilder.withBodyParam("participant[name]", name);
        }

        final String challongeUsername = request.getChallongeUsername();
        if(challongeUsername != null) {
            requestBuilder.withBodyParam("participant[challonge_username]", challongeUsername);
        }

        final String email = request.getEmail();
        if(email != null) {
            requestBuilder.withBodyParam("participant[email]", email);
        }

        final Integer seed = request.getSeed();
        if(seed != null) {
            requestBuilder.withBodyParam("participant[seed]", seed.toString());
        }

        final String misc = request.getMisc();
        if(misc != null) {
            requestBuilder.withBodyParam("participant[misc]", misc);
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return participantParser.parse(httpResponse.getBody());
    }

    public Participant deleteParticipant(final String tournamentUrlPath, final int participantId) {
        return deleteParticipant(new DeleteParticipantRequest(tournamentUrlPath, participantId));
    }

    public Participant deleteParticipant(final DeleteParticipantRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final int participantUrlPath = request.getParticipantId();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/participants/" + participantUrlPath + ".xml");

        requestBuilder.withMethod(HttpMethod.DELETE);

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return participantParser.parse(httpResponse.getBody());
    }

    public List<Participant> randomizeTournamentSeeds(final String tournamentUrlPath) {
        return randomizeTournamentSeeds(new RandomizeTournamentSeedsRequest(tournamentUrlPath));
    }

    public List<Participant> randomizeTournamentSeeds(final RandomizeTournamentSeedsRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/participants/randomize.xml");

        requestBuilder.withMethod(HttpMethod.POST);

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return participantsParser.parse(httpResponse.getBody());
    }

    public List<Match> listMatches(final String tournamentUrlPath) {
        final ListMatchRequest request = new ListMatchRequest.Builder(tournamentUrlPath).build();
        return listMatches(request);
    }

    public List<Match> listMatches(final ListMatchRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/matches.xml");

        final String state = request.getState();
        if(state != null) {
            requestBuilder.withQueryParam("state", state);
        }

        final Integer participantId = request.getParticipantId();
        if(participantId != null) {
            requestBuilder.withQueryParam("participant_id", participantId.toString());
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return matchesParser.parse(httpResponse.getBody());
    }

    public Match getMatch(final String tournamentUrlPath, final int matchId) {
        return getMatch(new GetMatchRequest(tournamentUrlPath, matchId));
    }

    public Match getMatch(final GetMatchRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final int matchId = request.getMatchId();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/matches/" + matchId + ".xml");

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return matchParser.parse(httpResponse.getBody());
    }

    public Match updateMatch(final UpdateMatchRequest request) {
        final String tournamentUrlPath = request.getTournamentUrlPath();
        final int matchId = request.getMatchId();
        final HttpRequest.Builder requestBuilder = new HttpRequest.Builder(BASE_URL + "tournaments/"
            + tournamentUrlPath + "/matches/" + matchId + ".xml");

        requestBuilder.withMethod(HttpMethod.PUT);

        final List<MatchScore> matchScores = request.getMatchScores();
        if(matchScores != null) {
            final StringBuilder allScores = new StringBuilder();
            for(MatchScore matchScore : matchScores) {
                allScores.append(matchScore).append(',');
            }
            allScores.deleteCharAt(allScores.length() - 1);

            requestBuilder.withBodyParam("match[scores_csv]", allScores.toString());
        }

        final Integer winnerId = request.getWinnerId();
        if(winnerId != null) {
            requestBuilder.withBodyParam("match[winner_id]", winnerId.toString());
        }

        final Boolean tie = request.isTie();
        if(tie != null && tie) {
            requestBuilder.withBodyParam("match[winner_id]", "tie");
        }

        final Integer playerOneVotes = request.getPlayerOneVotes();
        if(playerOneVotes != null) {
            requestBuilder.withBodyParam("match[player1_votes]", playerOneVotes.toString());
        }

        final Integer playerTwoVotes = request.getPlayerTwoVotes();
        if(playerTwoVotes != null) {
            requestBuilder.withBodyParam("match[player2_votes]", playerTwoVotes.toString());
        }

        final HttpResponse httpResponse = httpInvoker.invoke(requestBuilder.build());
        return matchParser.parse(httpResponse.getBody());
    }
}