import React from 'react';

const Decorators = [
  {
    component: React.createClass({
      render() {
        return (
          <div>
            <i className="fa fa-chevron-circle-left fa-3x"
               onClick={this.props.previousSlide} aria-hidden="true"></i>
          </div>
        )
      }
    }),
    position: 'CenterLeft',
    style: {
      padding: 20
    }
  },
  {
    component: React.createClass({
      render() {
        return (
          <div>
            <i className="fa fa-chevron-circle-right fa-3x"
               onClick={this.props.nextSlide} aria-hidden="true"></i>
          </div>
        )
      }
    }),
    position: 'CenterRight',
    style: {
      padding: 20
    }
  },
  {
    component: React.createClass({
      render() {
        var self = this;
        var indexes = this.getIndexes(self.props.slideCount, self.props.slidesToScroll);
        return (
          <ul style={self.getListStyles()}>
            {
              indexes.map(function (index) {
                return (
                  <li style={self.getListItemStyles()} key={index}>
                    <button
                      style={self.getButtonStyles(self.props.currentSlide === index)}
                      onClick={self.props.goToSlide.bind(null, index)}>
                      &bull;
                    </button>
                  </li>
                )
              })
            }
          </ul>
        )
      },
      getIndexes(count, inc) {
        var arr = [];
        for (var i = 0; i < count; i += inc) {
          arr.push(i);
        }
        return arr;
      },
      getListStyles() {
        return {
          position: 'relative',
          margin: 0,
          top: -10,
          padding: 0
        }
      },
      getListItemStyles() {
        return {
          listStyleType: 'none',
          display: 'inline-block'
        }
      },
      getButtonStyles(active) {
        return {
          border: 0,
          background: 'transparent',
          color: 'black',
          cursor: 'pointer',
          padding: 10,
          outline: 0,
          fontSize: 24,
          opacity: active ? 1 : 0.5
        }
      }
    }),
    position: 'BottomCenter'
  }
];

export default Decorators;
