import React from 'react';
import './Vets.css';
import {Grid, Col, Row, Thumbnail, Button} from 'react-bootstrap';
import {Link} from 'react-router';
import {connect} from 'react-redux'
import {changeView} from './actionCreators'

const mapStateToProps = (state) => ({
    vets: state.vetsData.vets,
    fetchingVets: state.vetsData.fetchingVets,
    offices: state.officesData.offices,
    fetchingOffices: state.officesData.fetchingOffices,
    viewThumbnail: state.vetsData.viewThumbnail,
});

const mapDispatchToProps = (dispatch) => ({
    changeView: () => dispatch(changeView())
});

class Vets extends React.Component {

    render() {
        var {
            vets,
            fetchingVets,
            offices,
            fetchingOffices,
            changeView,
            viewThumbnail
        }= this.props;

        return (
            <Grid>
                <Row>
                {fetchingVets ? <p>Ładuję weterynarzy...</p> : null}

                {vets
                    .map( (vet,index) => (
                        <Col xs={6} md={4}>

                                    <img src={vet.photo} alt={vet.firstName} className="img-responsive vets-img"/>

                                    <Link to={`/vets/` + parseInt(index + 1, 10) }>
                                        <strong>{vet.firstName} {vet.lastName}</strong>
                                    </Link>
                                    <p>E-mail: {vet.email}</p>
                                    <p>Telefon: {vet.phone}</p>

                                    <p>Przychodnie:</p>
                                    {fetchingOffices ? <p>Ładuję przychodnie...</p> : null}
                                    <ul>
                                        {offices
                                            .filter(function (office) {
                                                var result = office.vetIds.indexOf(vet.id) !== -1
                                                {
                                                    console.log(office.vetIds)
                                                }
                                                return result
                                            })
                                            .map(function (item) {
                                                return item
                                            })
                                            .map(function (office) {
                                                return (
                                                    <Link key={office.officeName}
                                                          to={`/offices/` + parseInt(office.id, 10)}>
                                                        <p>{office.officeName}</p>
                                                    </Link>
                                                )
                                            })}
                                    </ul>
                                    <p>Liczba porad lekarza: {vet.advices.length}</p>
                            </Col>
                    ))
                }
                </Row>
            </Grid>
        )
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Vets)


