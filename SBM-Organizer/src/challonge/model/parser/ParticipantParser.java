package challonge.model.parser;

import challonge.model.Match;
import challonge.model.Participant;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 8:03 PM
 */
public class ParticipantParser extends Parser<Participant> {
    private final ListParser<Match> matchesParser;

    public ParticipantParser(final ListParser<Match> matchesParser) {
        this.matchesParser = matchesParser;
    }

    @Override
    protected Participant parse(XMLStreamReader xmlReader) {
        Participant.Builder builder = new Participant.Builder();
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
                                case "active":
                                    final boolean active = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doActive(active);
                                    break;
                                case "checked-in":
                                    final boolean checkedIn = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doCheckedIn(checkedIn);
                                    break;
                                case "created-at":
                                    builder.withCreatedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "final-rank":
                                    final int finalRank = Integer.valueOf(xmlReader.getElementText());
                                    builder.withFinalRank(finalRank);
                                    break;
                                case "group-id":
                                    final int groupId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withGroupId(groupId);
                                    break;
                                case "icon":
                                    builder.withIcon(xmlReader.getElementText());
                                    break;
                                case "id":
                                    final int id = Integer.valueOf(xmlReader.getElementText());
                                    builder.withId(id);
                                    break;
                                case "invitation-id":
                                    final int invitationId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withInvitationId(invitationId);
                                    break;
                                case "invite-email":
                                    builder.withInviteEmail(xmlReader.getElementText());
                                    break;
                                case "misc":
                                    builder.withMisc(xmlReader.getElementText());
                                    break;
                                case "name":
                                    builder.withName(xmlReader.getElementText());
                                    break;
                                case "on-waiting-list":
                                    final boolean onWaitingList = Boolean.valueOf(xmlReader.getElementText());
                                    builder.doOnWaitingList(onWaitingList);
                                    break;
                                case "seed":
                                    final int seed = Integer.valueOf(xmlReader.getElementText());
                                    builder.withSeed(seed);
                                    break;
                                case "tournament-id":
                                    final int tournamentId = Integer.valueOf(xmlReader.getElementText());
                                    builder.withTournamentId(tournamentId);
                                    break;
                                case "updated-at":
                                    builder.withUpdatedAt(DateFormats.PARSER_SDF.get().parse(xmlReader.getElementText()));
                                    break;
                                case "challonge-username":
                                    builder.withChallongeUsername(xmlReader.getElementText());
                                    break;
                                case "challonge-email-address-verified":
                                    builder.withChallongeEmailAddressVerified(xmlReader.getElementText());
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
                            case "participant":
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
        throw new IllegalArgumentException("Couldn't parse Participant from xml");
    }
}
