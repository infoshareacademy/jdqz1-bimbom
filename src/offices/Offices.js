import React from 'react';
import './offices-styles.css';
import '../data/offices.js';
import {Link} from 'react-router';
import {connect} from 'react-redux';
import {
    Grid,
        Row,
        Col,
        Panel
}
from 'react-bootstrap';
import Rcslider from 'rc-slider';
import '../../node_modules/rc-slider/assets/index.css';
import {
    selectNumberOfVets
} from
'./actionCreators'


const mapStateToProps = (state) => ({
    vetsOffices: state.officesData.offices,
    fetchingOffices: state.officesData.fetchingOffices,
    rangeFilter: state.officesData.rangeFilter
});

const mapDispatchToProps = (dispatch) => ({
    selectNumberOfVets: (values) => dispatch(selectNumberOfVets(values))
});


class Offices extends React.Component {
    render() {
        var {
            vetsOffices,
            fetchingOffices,
            selectNumberOfVets,
            minValue = 1,
            maxValue = 10,
            values = [minValue, maxValue],
            rangeFilter = office => office.vetIds.length >= values[0] && office.vetIds.length <= values[1]
        }=this.props;
        return (
            <Grid>
                <Row>
                    <Col xs={12} mdOffset={2} md={10}>
                        <Rcslider
                            className="rc-slider"
                            min={minValue}
                            max={maxValue}
                            step={1}
                            range={true}
                            defaultValue={[minValue, maxValue]}
                            onChange={(values) => selectNumberOfVets(values)}
                        />
                    </Col>
                </Row>
                <Row>
                    <Col xs={12} mdOffset={2}
                         md={10}>
                        {fetchingOffices ? 'Proszę czekać, trwa ładowanie listy gabinetów...' : null}
                        {vetsOffices
                            .filter(rangeFilter)
                            .map(function (office) {
                                return (
                                    <Link to={`/offices/${office.id}`}
                                          key={office.id}>
                                        <Panel className="office-list-container">
                                            <Col xs={12} md={2}>
                                                <img src={office.logo} alt="Logo"/>
                                            </Col>
                                            <Col xs={12} md={10}>
                                                <span><strong>{office.officeName}</strong></span>
                                                <br/>
                                                <span>{office.officeAddress}</span>
                                                <br/>

                                                <span>Liczba lekarzy: {office.vetIds.length}</span>
                                            </Col>
                                        </Panel>
                                    </Link>
                                )
                            })
                        }
                    </Col>
                </Row>
            </Grid>
        )
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Offices)