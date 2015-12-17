package model.model.parser;

import model.model.Match;
import model.model.MatchScore;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.text.ParseException;
import java.util.*;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 8:02 PM
 */
public class MatchParser extends Parser<Match> {
    @Override
    protected Match parse(XMLStreamReader xmlReader) {
        Match.Builder builder = new Match.Builder();
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
                                case "created-at":
                                    builder.withCreatedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "group-id":
                                    final int groupId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withGroupId(groupId);
                                    break;
                                case "has-attachment":
                                    final boolean hasAttachment = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doHasAttachment(hasAttachment);
                                    break;
                                case "id":
                                    final int id = Integer.valueOf(xmlReader.getElementText());
                                    builder.withId(id);
                                    break;
                                case "identifier":
                                    builder.withIdentifier(xmlReader.getElementText());
                                    break;
                                case "loser-id":
                                    final int loserId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withLoserId(loserId);
                                    break;
                                case "player1-id":
                                    final int playerOneId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPlayerOneId(playerOneId);
                                    break;
                                case "player1-is-prereq-match-loser":
                                    final boolean playerOneIsPrereqMatchLoser = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doPlayerOneIsPrereqMatchLoser(playerOneIsPrereqMatchLoser);
                                    break;
                                case "player1-prereq-match-id":
                                    final int playerOnePrereqMatchId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPlayerOnePrereqMatchId(playerOnePrereqMatchId);
                                    break;
                                case "player1-votes":
                                    final int playerOneVotes = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPlayerOneVotes(playerOneVotes);
                                    break;
                                case "player2-id":
                                    final int playerTwoId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPlayerTwoId(playerTwoId);
                                    break;
                                case "player2-is-prereq-match-loser":
                                    final boolean playerTwoIsPrereqMatchLoser = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doPlayerTwoIsPrereqMatchLoser(playerTwoIsPrereqMatchLoser);
                                    break;
                                case "player2-prereq-match-id":
                                    final int playerTwoPrereqMatchId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPlayerTwoPrereqMatchId(playerTwoPrereqMatchId);
                                    break;
                                case "player2-votes":
                                    final int playerTwoVotes = Integer.valueOf(xmlReader.getElementText());
                                    builder.withPlayerTwoVotes(playerTwoVotes);
                                    break;
                                case "round":
                                    final int round = Integer.valueOf(xmlReader.getElementText());
                                    builder.withRound(round);
                                    break;
                                case "started-at":
                                    builder.withStartedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "state":
                                    builder.withState(xmlReader.getElementText());
                                    break;
                                case "tournament-id":
                                    final int tournamentId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withTournamentId(tournamentId);
                                    break;
                                case "updated-at":
                                    builder.withUpdatedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "winner-id":
                                    final int winnerId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withWinnerId(winnerId);
                                    break;
                                case "prerequisite-match-ids-csv":
                                    final List<Integer> ids = new ArrayList<>();

                                    final String rawPrereqMatchIds = xmlReader.getElementText();
                                    if(rawPrereqMatchIds.length() > 0) {
                                        final String[] prereqMatchIds = rawPrereqMatchIds.split(",");

                                        for(String prereqMatchId : prereqMatchIds) {
                                            ids.add(Integer.parseInt(prereqMatchId));
                                        }
                                    }
                                    builder.withPrereqMatchIds(ids);
                                    break;
                                case "scores-csv":
                                    final String rawScores = xmlReader.getElementText();
                                    final String[] scores = rawScores.split(",");

                                    final List<MatchScore> matchScores = new ArrayList<>();
                                    for(String score : scores) {
                                        int index;
                                        if(score.length() > 0) {
                                            if(score.charAt(0) == '-') {
                                                index = score.indexOf('-', 1);
                                            } else {
                                                index = score.indexOf('-');
                                            }
                                            final int playerOneScore = Integer.parseInt(score.substring(0, index));
                                            final int playerTwoScore = Integer.parseInt(score.substring(index + 1));

                                            matchScores.add(new MatchScore(playerOneScore, playerTwoScore));
                                        }
                                    }
                                    builder.withScores(matchScores);
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        switch(xmlReader.getLocalName()) {
                            case "match":
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
        throw new IllegalArgumentException("Couldn't parse Match from xml");
    }
}
