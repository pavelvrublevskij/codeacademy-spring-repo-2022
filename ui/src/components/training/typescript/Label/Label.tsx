import React, { useState } from 'react';
import { CommonFC, CommonProps } from '../common/CommonFC';

interface LabelProps extends CommonProps {
    text: string;
}

const Label: CommonFC<LabelProps> = ({
    text,
    onClick
}) => {
    const [clickedLabel, setClickedLabel] = useState<string>('');

    const handleClick = () => {
        setClickedLabel('testas');
    }

    return (
      <div onClick={handleClick}>
          {clickedLabel || text}
      </div>
    );
}

export default Label;
